package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultProgressIndicator(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.background
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = background.copy(alpha = 0.6f))
    ) {

        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

    }

}