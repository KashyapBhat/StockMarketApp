
package kashyap.learning.stocktrading.stockmarket.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recommendations(
    @SerialName("symbol") val symbol: String,
    @SerialName("buy") val buy: Int,
    @SerialName("hold") val hold: Int,
    @SerialName("sell") val sell: Int
)