package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    background: Color = MaterialTheme.colors.primarySurface,
    title: String,
) {

    TopAppBar(
        title = { DefaultText(title = title) },
        modifier = modifier,
        navigationIcon = icon,
        actions = actions,
        backgroundColor = background,
        elevation = 8.dp,
    )

}