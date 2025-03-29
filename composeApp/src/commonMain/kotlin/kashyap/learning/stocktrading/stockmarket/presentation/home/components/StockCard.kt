package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle

@Composable
fun StockCard(
    logoUrl: String,
    ticker: String,
    companyName: String
) {
    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = logoUrl,
            contentDescription = "logo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Column(
            modifier = Modifier.padding(start = 16.dp)

        ) {
            AppText(
                text = ticker,
                style = AppTextStyle.TitleMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppText(
                text = companyName,
                style = AppTextStyle.BodyMedium,
                color = Color.LightGray
            )
        }
    }
}