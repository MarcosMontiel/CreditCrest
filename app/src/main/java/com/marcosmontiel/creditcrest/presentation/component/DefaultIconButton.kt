package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray200

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    color: Color = Gray200,
    icon: ImageVector,
    description: String,
    click: () -> Unit,
) {

    IconButton(onClick = { click() }, modifier = modifier) {
        Icon(imageVector = icon, contentDescription = description, tint = color)
    }

}