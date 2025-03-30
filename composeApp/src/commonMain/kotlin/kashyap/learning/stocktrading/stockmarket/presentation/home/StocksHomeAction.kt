package kashyap.learning.stocktrading.stockmarket.presentation.home

import kashyap.learning.stocktrading.stockmarket.domain.StockInfo

sealed interface StocksHomeAction {
    data class OnStockClick(val stockInfo: StockInfo): StocksHomeAction
}