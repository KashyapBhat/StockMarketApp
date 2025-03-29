package kashyap.learning.stocktrading.core.data

import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kashyap.learning.stocktrading.core.domain.DataError
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext
import kashyap.learning.stocktrading.core.domain.Result

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, DataError.Remote> {
    val response = try {
        execute()
    } catch (e: SocketTimeoutException) {
        return Result.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: UnresolvedAddressException) {
        return Result.Error(DataError.Remote.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(DataError.Remote.UNKNOWN)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, DataError.Remote> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(DataError.Remote.SERIALIZATION)
            }
        }

        401 -> Result.Error(DataError.Remote.AUTHENTICATION)
        408 -> Result.Error(DataError.Remote.REQUEST_TIMEOUT)
        429 -> Result.Error(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Remote.SERVER)
        else -> Result.Error(DataError.Remote.UNKNOWN)
    }
}

inline fun <A, B, C, R> mergeResults(
    resultA: Result<A, DataError.Remote>,
    resultB: Result<B, DataError.Remote>,
    resultC: Result<C, DataError.Remote>,
    transform: (A, B, C) -> R
): Result<R, DataError.Remote> {
    return when {
        resultA is Result.Error -> resultA
        resultB is Result.Error -> resultB
        resultC is Result.Error -> resultC
        resultA is Result.Success && resultB is Result.Success && resultC is Result.Success ->
            Result.Success(transform(resultA.data, resultB.data, resultC.data))
        else -> Result.Error(DataError.Remote.UNKNOWN)
    }
}