package kashyap.learning.stocktrading.stockmarket.data.network

import kashyap.learning.stocktrading.core.data.mergeResults
import kashyap.learning.stocktrading.core.domain.DataError
import kashyap.learning.stocktrading.core.domain.Result
import kashyap.learning.stocktrading.stockmarket.data.clients.FinHubAPIClient
import kashyap.learning.stocktrading.stockmarket.data.dto.StockInfoDto
import kashyap.learning.stocktrading.stockmarket.data.dto.toStockInfoDto

class KtorRemoteStocksHomeDataSource(
    private val apiClient: FinHubAPIClient
) : RemoteStocksHomeDataSource {

    override suspend fun getRecommendedAndFavoriteStocks(symbol: String): Result<StockInfoDto, DataError.Remote> {
        return mergeResults(
            apiClient.getStockQuote(symbol),
            apiClient.getRecommendationTrends(symbol),
            apiClient.getCompanyProfile(symbol)
        ) { quote, trends, companyProfile -> symbol.toStockInfoDto(trends, quote, companyProfile) }
    }
}