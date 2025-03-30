package kashyap.learning.stocktrading.stockmarket.domain

data class StockInfo(
    val id: String,
    val symbol: String,
    val fullName: String,
    val stockType: StockType,
    val stockImageUrl: String,
    val ltp: String
)

sealed interface StockType {
    data class Recommended(val buy: String, val sell: String) : StockType
    data class Watchlist(val changePercentage: String) : StockType
}