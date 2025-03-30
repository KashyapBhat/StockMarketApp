package kashyap.learning.stocktrading.core.presentation

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

val AppBlue = Color(0xFF487FD9)
val AppRed = Color(0xFFFF3165)
val AppGreen = Color(0xFF00FF66)
val AppBlack = Color(0xFF16171C)

val DarkBlue = Color(0xFF092E66)
val DesertWhite = Color(0xFFF7F7F7)
val SandYellow = Color(0xFFFFBD64)
val LightBlue = Color(0xFF9AD9FF)
val Violet = Color(0xFF6A1B9A)
val DarkGrey = Color(0xFF4b514a)
val DarkRed = Color(0xFF410a19)

val cardColors = listOf(DarkGrey, DarkBlue, Violet)

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