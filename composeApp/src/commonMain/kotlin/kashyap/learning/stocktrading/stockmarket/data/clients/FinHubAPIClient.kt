package kashyap.learning.stocktrading.stockmarket.data.clients

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kashyap.learning.stocktrading.core.data.safeCall
import kashyap.learning.stocktrading.core.domain.DataError
import kashyap.learning.stocktrading.core.domain.Result
import kashyap.learning.stocktrading.stockmarket.data.dto.CompanyProfile
import kashyap.learning.stocktrading.stockmarket.data.dto.Recommendations
import kashyap.learning.stocktrading.stockmarket.data.dto.StockQuote

class FinHubAPIClient(private val client: HttpClient) {

    private val API_KEY = "YOUR_API_KEY"
    private val BASE_URL = "https://finnhub.io/api"

    suspend fun getStockQuote(symbol: String): Result<StockQuote, DataError.Remote> {
        return safeCall<StockQuote> {
            client.get("$BASE_URL/v1/quote") {
                parameter("symbol", symbol)
                parameter("token", API_KEY)
            }
        }
    }

    suspend fun getRecommendationTrends(symbol: String): Result<List<Recommendations>, DataError.Remote> {
        return safeCall<List<Recommendations>> {
            client.get("$BASE_URL/v1/stock/recommendation") {
                parameter("symbol", symbol)
                parameter("token", API_KEY)
            }
        }
    }

    suspend fun getCompanyProfile(symbol: String): Result<CompanyProfile, DataError.Remote> {
        return safeCall<CompanyProfile> {
            client.get("$BASE_URL/v1/stock/profile2") {
                parameter("symbol", symbol)
                parameter("token", API_KEY)
            }
        }
    }
}