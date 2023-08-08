package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    text: String,
    valueChanged: (String) -> Unit,
) {

    TextField(
        value = text,
        onValueChange = { valueChanged(it) },
        modifier = modifier,
        enabled = isEnabled,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )

}