package kashyap.learning.stocktrading.stockmarket.domain

import kashyap.learning.stocktrading.core.domain.DataError
import kashyap.learning.stocktrading.core.domain.Result

interface StockHomeRepository {
    suspend fun getRecommendedAndFavoriteStocks(symbol: String): Result<StockInfo, DataError.Remote>
}