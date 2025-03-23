package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import stocktradingapp.composeapp.generated.resources.Res
import stocktradingapp.composeapp.generated.resources.notification
import stocktradingapp.composeapp.generated.resources.say_hello
import stocktradingapp.composeapp.generated.resources.say_welcome

@Composable
fun HomeTitleContent() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            AppText(
                stringResource(Res.string.say_hello),
                style = AppTextStyle.BodyMedium,
                color = Color.White,
            )
            AppText(
                stringResource(Res.string.say_welcome),
                style = AppTextStyle.TitleMedium,
                color = Color.White,
            )
        }
        Box(Modifier.size(24.dp)) {
            Image(painterResource(Res.drawable.notification), null)
        }
    }
}
