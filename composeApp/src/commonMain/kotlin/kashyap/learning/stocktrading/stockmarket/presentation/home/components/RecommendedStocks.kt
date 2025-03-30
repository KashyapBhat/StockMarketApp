package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.DarkBlue
import kashyap.learning.stocktrading.core.presentation.DarkGrey
import kashyap.learning.stocktrading.core.presentation.Violet
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kashyap.learning.stocktrading.stockmarket.domain.StockType
import org.jetbrains.compose.resources.stringResource
import stocktradingapp.composeapp.generated.resources.Res
import stocktradingapp.composeapp.generated.resources.recommended

@Composable
fun RecommendedStocks(recommendedStocks: List<StockInfo>) {
    val colors = listOf(DarkGrey, DarkBlue, Violet)
    Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 36.dp)) {
        AppText(
            text = stringResource(Res.string.recommended),
            style = AppTextStyle.TitleMedium
        )
        LazyRow(
            modifier = Modifier.padding(top = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recommendedStocks.size) {
                val backgroundColor = colors[it % colors.size]
                RecommendedStockCard(recommendedStocks[it], backgroundColor)
            }
        }
    }
}

@Composable
fun RecommendedStockCard(stockInfo: StockInfo, backgroundColor: Color) {
    Card(
        modifier = Modifier.size(160.dp, 120.dp)
            .clip(RoundedCornerShape(12.dp)),
        backgroundColor = backgroundColor,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            StockCard(stockInfo.stockImageUrl, stockInfo.symbol, stockInfo.fullName)
            Spacer(modifier = Modifier.height(8.dp))
            (stockInfo.stockType as? StockType.Recommended)?.let { type ->
                StockPriceRow(stockInfo.ltp, type.buy, type.sell)
            }
        }
    }
}

@Composable
private fun StockPriceRow(ltp: String, buy: String, sell: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppText(text = ltp, style = AppTextStyle.TitleMedium, color = Color.White)
        PercentageChangeText(buy, buy > sell, Modifier)
        PercentageChangeText(sell, buy <= sell, Modifier)
    }
}