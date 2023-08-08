package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultTextField(modifier: Modifier = Modifier, text: String) {

    TextField(value = text, onValueChange = {}, modifier = modifier)

}