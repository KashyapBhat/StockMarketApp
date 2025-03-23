package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import stocktradingapp.composeapp.generated.resources.Res
import stocktradingapp.composeapp.generated.resources.bussiness_man
import stocktradingapp.composeapp.generated.resources.recommended

@Composable
fun RecommendedStocks() {
    Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 36.dp)) {
        AppText(
            text = stringResource(Res.string.recommended),
            style = AppTextStyle.TitleMedium,
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(5) {
                RecommendedStockCard(
                    logo = painterResource(Res.drawable.bussiness_man),
                    ticker = "APPL",
                    companyName = "Apple Inc.",
                    price = "198.24",
                    change = "2.5%",
                    isPositive = true
                )
            }
        }
    }
}

@Composable
fun RecommendedStockCard(
    logo: Painter,
    ticker: String,
    companyName: String,
    price: String,
    change: String,
    isPositive: Boolean
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            StockCard(logo, ticker, companyName)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppText(
                    text = price,
                    style = AppTextStyle.TitleMedium,
                    color = Color.White
                )
                PercentageChangeText(change, isPositive, Modifier)
            }
        }
    }
}

