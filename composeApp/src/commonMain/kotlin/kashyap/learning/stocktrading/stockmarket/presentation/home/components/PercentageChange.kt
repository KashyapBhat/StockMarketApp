package kashyap.learning.stocktrading.stockmarket.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kashyap.learning.stocktrading.core.presentation.AppGreen
import kashyap.learning.stocktrading.core.presentation.AppRed
import kashyap.learning.stocktrading.core.presentation.widgets.AppText
import kashyap.learning.stocktrading.core.presentation.widgets.AppTextStyle

@Composable
fun PercentageChangeText(
    change: String,
    isPositive: Boolean,
    rowModifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = rowModifier
    ) {
        Icon(
            imageVector = if (isPositive) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = "indicator",
            tint = if (isPositive) AppGreen else AppRed,
            modifier = Modifier.size(12.dp)
        )
        AppText(
            text = change,
            style = AppTextStyle.BodyMedium,
            color = if (isPositive) AppGreen else AppRed
        )
    }
}