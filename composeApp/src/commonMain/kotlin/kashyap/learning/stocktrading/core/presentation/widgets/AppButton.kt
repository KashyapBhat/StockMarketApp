package kashyap.learning.stocktrading.core.presentation.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.AppBlue
import kashyap.learning.stocktrading.core.presentation.AppRed

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.PRIMARY
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        enabled = enabled,
        elevation = if (variant == ButtonVariant.TEXT) ButtonDefaults.elevation(0.dp, 0.dp, 0.dp) else ButtonDefaults.elevation(),
        shape = RoundedCornerShape(4.dp),
        colors = when (variant) {
            ButtonVariant.PRIMARY -> ButtonDefaults.buttonColors(backgroundColor = AppBlue)
            ButtonVariant.ERROR -> ButtonDefaults.buttonColors(backgroundColor = AppRed)
            ButtonVariant.TEXT -> ButtonDefaults.textButtonColors(backgroundColor = Color.Transparent)
        }
    ) {
        AppText(text = text, style = AppTextStyle.BodyLarge)
    }
}
enum class ButtonVariant { PRIMARY, ERROR, TEXT }
