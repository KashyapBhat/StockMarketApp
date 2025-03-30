package kashyap.learning.stocktrading.stockmarket.data.mappers

import kashyap.learning.stocktrading.stockmarket.data.dto.StockInfoDto
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.stockmarket.domain.StockType
import kotlin.math.abs
import kotlin.math.round

fun StockInfoDto.toStockInfo(): StockInfo {
    val stockType = StockType.Watchlist(
        changePercentage = if (currentPrice != null && prevClosePrice != null && prevClosePrice != 0.0) {
            val percentage = abs(currentPrice - prevClosePrice) / prevClosePrice * 100
            "${round(percentage * 100) / 100}%"
        } else {
            "0.00%"
        }
    )

    return StockInfo(
        id = symbol,
        symbol = symbol,
        fullName = fullName,
        stockType = stockType,
        stockImageUrl = logoUrl,
        ltp = currentPrice.toString()
    )
}