package kashyap.learning.stocktrading.stockmarket.data.repository

import kashyap.learning.stocktrading.core.domain.DataError
import kashyap.learning.stocktrading.stockmarket.data.network.RemoteStocksHomeDataSource
import kashyap.learning.stocktrading.stockmarket.domain.StockHomeRepository
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.core.domain.Result
import kashyap.learning.stocktrading.core.domain.map
import kashyap.learning.stocktrading.stockmarket.data.mappers.toStockInfo

class DefaultStocksHomeRepository(
    private val remoteStocksHomeDataSource: RemoteStocksHomeDataSource
): StockHomeRepository {

    override suspend fun getRecommendedAndFavoriteStocks(symbol: String): Result<StockInfo, DataError.Remote> {
        return remoteStocksHomeDataSource
            .getRecommendedAndFavoriteStocks(symbol)
            .map {
                it.toStockInfo()
            }
    }
}