package kashyap.learning.stocktrading.stockmarket.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyProfile(
    @SerialName("name")
    val companyName: String? = null,
    @SerialName("logo")
    val logoUrl: String? = null,
    @SerialName("finnhubIndustry")
    val industry: String? = null,
    @SerialName("ticker")
    val symbol: String? = null
)