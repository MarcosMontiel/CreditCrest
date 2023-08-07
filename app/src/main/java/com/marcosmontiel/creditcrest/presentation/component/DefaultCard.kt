package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        content()
    }

}