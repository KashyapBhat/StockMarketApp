package kashyap.learning.stocktrading.stockmarket.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StockQuote(
    @SerialName("c") val currentPrice: Double?,
    @SerialName("h") val highPrice: Double?,
    @SerialName("l") val lowPrice: Double?,
    @SerialName("o") val openPrice: Double?,
    @SerialName("pc") val prevClosePrice: Double?
)