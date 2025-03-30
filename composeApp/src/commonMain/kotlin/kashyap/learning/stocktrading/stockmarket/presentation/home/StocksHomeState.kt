package kashyap.learning.stocktrading.stockmarket.presentation.home

import kashyap.learning.stocktrading.core.presentation.UiText
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.stockmarket.domain.StockType

data class StocksHomeState(
    val uiStocks: ArrayList<StockInfo>,
    val isLoading: Boolean = true,
    val errorMessage: UiText? = null
) {
    val recommendedStocks: List<StockInfo> by lazy {
        uiStocks.filter { it.stockType is StockType.Recommended }
    }

    val watchlistStocks: List<StockInfo> by lazy {
        uiStocks.filter { it.stockType is StockType.Watchlist }
    }
}