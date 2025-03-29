package kashyap.learning.stocktrading.stockmarket.data.mappers

import kashyap.learning.stocktrading.stockmarket.data.dto.StockInfoDto
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.stockmarket.domain.StockType

fun StockInfoDto.toStockInfo(): StockInfo {
    val stockType = StockType.Recommended(
        buy = buy.toString(),
        sell = sell.toString()
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