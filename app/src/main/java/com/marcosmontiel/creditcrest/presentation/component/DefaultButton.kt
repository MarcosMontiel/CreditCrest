package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    padding: PaddingValues = PaddingValues(vertical = 16.dp),
    content: @Composable RowScope.() -> Unit,
    click: () -> Unit
) {
    Button(
        onClick = click,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        contentPadding = padding,
        content = content
    )
}