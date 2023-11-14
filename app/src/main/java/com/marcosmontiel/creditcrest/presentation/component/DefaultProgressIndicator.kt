package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundLightColor

@Composable
fun DefaultProgressIndicator(
    modifier: Modifier = Modifier,
    background: Color = if (isSystemInDarkTheme()) BackgroundDarkColor else BackgroundLightColor,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = background.copy(alpha = 0.6f)
            )
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }

}