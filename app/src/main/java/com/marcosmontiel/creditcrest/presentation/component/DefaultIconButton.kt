package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String,
    click: () -> Unit,
) {

    IconButton(onClick = { click() }, modifier = modifier) {
        Icon(imageVector = icon, contentDescription = description)
    }

}