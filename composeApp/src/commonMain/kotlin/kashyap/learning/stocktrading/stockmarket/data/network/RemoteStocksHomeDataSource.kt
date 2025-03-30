package kashyap.learning.stocktrading.stockmarket.data.network


import kashyap.learning.stocktrading.core.domain.DataError
import kashyap.learning.stocktrading.core.domain.Result
import kashyap.learning.stocktrading.stockmarket.data.dto.StockInfoDto

interface RemoteStocksHomeDataSource {
    suspend fun getRecommendedAndFavoriteStocks(symbol: String): Result<StockInfoDto, DataError.Remote>
}
