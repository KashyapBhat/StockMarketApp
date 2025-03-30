package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.cardColors
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.stockmarket.domain.StockType
import org.jetbrains.compose.resources.stringResource
import stocktradingapp.composeapp.generated.resources.Res
import stocktradingapp.composeapp.generated.resources.watchlist

@Composable
fun WatchListStocks(watchlistStocks: List<StockInfo>) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
        AppText(
            text = stringResource(Res.string.watchlist),
            style = AppTextStyle.TitleMedium,
        )
        LazyColumn(
            modifier = Modifier.padding(top = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(watchlistStocks.size) {
                WatchListCard(watchlistStocks[it], cardColors[it % cardColors.size])
            }
        }
    }
}

@Composable
fun WatchListCard(stockInfo: StockInfo, backgroundColor: Color) {
    Card(
        modifier = Modifier.clip(RoundedCornerShape(12.dp)),
        backgroundColor = backgroundColor,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp, bottom = 12.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            StockCard(stockInfo.stockImageUrl, stockInfo.symbol, stockInfo.fullName)
            AppText(
                text = stockInfo.ltp, style = AppTextStyle.TitleMedium, color = Color.White
            )
            if (stockInfo.stockType is StockType.Watchlist)
                PercentageChangeText(
                    stockInfo.stockType.changePercentage,
                    stockInfo.stockType.changePercentage.toDoubleOrNull()?.let { it > 0 } ?: false,
                    Modifier.padding(end = 12.dp))
        }
    }
}