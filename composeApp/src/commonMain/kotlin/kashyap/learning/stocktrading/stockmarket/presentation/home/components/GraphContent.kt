package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.AppRed
import kashyap.learning.stocktrading.core.presentation.DarkRed
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle
import org.jetbrains.compose.resources.stringResource
import stocktradingapp.composeapp.generated.resources.Res
import stocktradingapp.composeapp.generated.resources.nifty_50

@Composable
fun GraphContent() {
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AppText(
                    text = stringResource(Res.string.nifty_50),
                    style = AppTextStyle.TitleSmall,
                    color = Color.LightGray
                )
                Row {
                    AppText(
                        text = "25,901.0", style = AppTextStyle.HeadlineLarge, color = Color.White
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Box(
                        modifier = Modifier.clip(RoundedCornerShape(16.dp)).background(DarkRed)
                    ) {
                        AppText(
                            text = "▼ 810%",
                            style = AppTextStyle.BodyMedium,
                            color = Color.White,
                            modifier = Modifier.padding(
                                start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp
                            )
                        )
                    }
                }
                AppText(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "1,521.4",
                    style = AppTextStyle.BodyMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun StockGraphView() {
    Box(
        modifier = Modifier.fillMaxWidth().height(180.dp).clip(RoundedCornerShape(16.dp))
            .background(Brush.verticalGradient(listOf(Color.Transparent, AppRed))),
    ) {
        Canvas(
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height),
                strokeWidth = 4f
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            listOf("1H", "4H", "1D", "3D", "7D").forEach { label ->
                AppText(
                    text = label,
                    style = AppTextStyle.BodyLarge,
                    color = if (label == "1H") Color.White else Color.Gray
                )
            }
        }
    }
}
