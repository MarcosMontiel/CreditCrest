package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    padding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable RowScope.() -> Unit,
    click: () -> Unit,
) {

    TextButton(
        onClick = { click() },
        modifier = modifier,
        enabled = isEnabled,
        contentPadding = padding,
        content = content,
    )

}