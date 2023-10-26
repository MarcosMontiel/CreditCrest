package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultFloatingActionButton(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.secondary,
    content: @Composable () -> Unit,
    click: () -> Unit,
) {

    FloatingActionButton(
        onClick = click,
        modifier = modifier.padding(bottom = 56.dp),
        backgroundColor = background,
        content = content,
    )

}