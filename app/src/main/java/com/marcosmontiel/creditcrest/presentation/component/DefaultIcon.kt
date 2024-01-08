package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DefaultIcon(
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    icon: ImageVector,
    description: String
) {
    Icon(imageVector = icon, contentDescription = description, modifier = modifier, tint = color)
}