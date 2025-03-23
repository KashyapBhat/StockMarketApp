package kashyap.learning.stocktrading.core.presentation.widgets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    style: AppTextStyle = AppTextStyle.BodyMedium,
    color: Color = Color.White
) {
    Text(
        text = text,
        modifier = modifier,
        style = when (style) {
            AppTextStyle.HeadlineLarge -> TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
            AppTextStyle.HeadlineMedium -> TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            AppTextStyle.HeadlineSmall -> TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            AppTextStyle.TitleLarge -> TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium)
            AppTextStyle.TitleMedium -> TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
            AppTextStyle.TitleSmall -> TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            AppTextStyle.BodyLarge -> TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
            AppTextStyle.BodyMedium -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)
            AppTextStyle.BodySmall -> TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)
            AppTextStyle.LabelLarge -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            AppTextStyle.LabelMedium -> TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            AppTextStyle.LabelSmall -> TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        },
        color = color
    )
}

enum class AppTextStyle {
    HeadlineLarge, HeadlineMedium, HeadlineSmall,
    TitleLarge, TitleMedium, TitleSmall,
    BodyLarge, BodyMedium, BodySmall,
    LabelLarge, LabelMedium, LabelSmall
}