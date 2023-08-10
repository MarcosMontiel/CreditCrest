package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultTextButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    padding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable RowScope.() -> Unit,
    click: () -> Unit,
) {

    TextButton(
        onClick = { click() },
        modifier = modifier,
        enabled = isEnabled,
        colors = colors,
        contentPadding = padding,
        content = content,
    )

}