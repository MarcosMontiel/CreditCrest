package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    icon: ImageVector,
    description: String,
    click: () -> Unit,
) {

    IconButton(onClick = click, modifier = modifier) {
        DefaultIcon(icon = icon, description = description, color = color)
    }

}