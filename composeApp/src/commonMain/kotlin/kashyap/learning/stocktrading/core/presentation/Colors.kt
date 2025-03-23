package kashyap.learning.stocktrading.core.presentation

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

val AppBlue = Color(0x487FD9)
val AppRed = Color(0xFF3165)
val AppGreen = Color(0x78CBBB)
val AppBlack = Color(0x16171C)

val DarkBlue = Color(0xFF0B405E)
val DesertWhite = Color(0xFFF7F7F7)
val SandYellow = Color(0xFFFFBD64)
val LightBlue = Color(0xFF9AD9FF)

val AppColor = darkColors(
    primary = AppBlue,
    onPrimary = Color.White,
    secondary = AppGreen,
    onSecondary = Color.White,
    background = AppBlack,
    onBackground = Color.White,
    surface = AppBlack,
    onSurface = Color.White,
    error = AppRed,
    onError = Color.White,
)