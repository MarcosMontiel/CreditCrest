package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue300
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue700

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    transformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    valueChanged: (String) -> Unit,
) {

    TextField(
        value = text,
        onValueChange = { valueChanged(it) },
        modifier = modifier,
        enabled = enabled,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        maxLines = 1,
        visualTransformation = transformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
        ),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedLabelColor = if (isSystemInDarkTheme()) Blue300 else Blue700,
        )
    )

}