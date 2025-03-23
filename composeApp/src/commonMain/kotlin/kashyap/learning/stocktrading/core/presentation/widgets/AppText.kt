package kashyap.learning.stocktrading.core.presentation.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import stocktradingapp.composeapp.generated.resources.AvenirNextLTPro_Bold
import stocktradingapp.composeapp.generated.resources.AvenirNextLTPro_Demi
import stocktradingapp.composeapp.generated.resources.AvenirNextLTPro_Regular
import stocktradingapp.composeapp.generated.resources.Res

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    style: AppTextStyle = AppTextStyle.BodyMedium,
    color: Color = Color.White
) {
    val letterSpacing = 0.2.sp
    val fontFamily = FontFamily(
        Font(Res.font.AvenirNextLTPro_Regular, FontWeight.Normal),
        Font(Res.font.AvenirNextLTPro_Demi, FontWeight.Medium),
        Font(Res.font.AvenirNextLTPro_Demi, FontWeight.SemiBold),
        Font(Res.font.AvenirNextLTPro_Bold, FontWeight.Bold)
    )
    Text(
        text = text,
        modifier = modifier,
        style = when (style) {
            AppTextStyle.HeadlineLarge -> TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.HeadlineMedium -> TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.HeadlineSmall -> TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.TitleLarge -> TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.TitleMedium -> TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.TitleSmall -> TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.BodyLarge -> TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.BodyMedium -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.BodySmall -> TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.LabelLarge -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.LabelMedium -> TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold, fontFamily = fontFamily, letterSpacing = letterSpacing)
            AppTextStyle.LabelSmall -> TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold, fontFamily = fontFamily, letterSpacing = letterSpacing)
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