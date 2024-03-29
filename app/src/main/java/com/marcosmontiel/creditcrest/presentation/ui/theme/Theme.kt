package com.marcosmontiel.creditcrest.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = Blue700,
    secondary = Gray500,
    background = BackgroundDarkColor,
    surface = BlueGray900,
    onPrimary = Gray100,
    onSecondary = Gray200,
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = Blue700,
    secondary = Gray700,
    background = BackgroundLightColor,
    surface = Gray200,
    onPrimary = Gray100,
    onSecondary = Gray600,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CreditCrestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}