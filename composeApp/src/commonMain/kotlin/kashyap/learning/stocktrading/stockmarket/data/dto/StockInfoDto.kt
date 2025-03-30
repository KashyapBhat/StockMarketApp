package kashyap.learning.stocktrading.stockmarket.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class StockInfoDto(
    val symbol: String,
    val fullName: String,
    val logoUrl: String,
    val currentPrice: Double?,
    val prevClosePrice: Double?,
    val buy: Int,
    val hold: Int,
    val sell: Int,
)

fun String.toStockInfoDto(
    recommendations: List<Recommendations>,
    quote: StockQuote,
    profile: CompanyProfile
): StockInfoDto {
    val latestTrend = recommendations.lastOrNull()

    require(latestTrend?.symbol == this) { "Symbol mismatch: Expected $this but got ${latestTrend?.symbol}" }

    return StockInfoDto(
        symbol = this,
        fullName = profile.companyName ?: "",
        logoUrl = profile.logoUrl ?: "",
        currentPrice = quote.currentPrice,
        prevClosePrice = quote.prevClosePrice,
        buy = latestTrend?.buy ?: 0,
        hold = latestTrend?.hold?: 0,
        sell = latestTrend?.sell?: 0
    )
}