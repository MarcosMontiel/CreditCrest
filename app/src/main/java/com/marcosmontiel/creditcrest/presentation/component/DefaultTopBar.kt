package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigation: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {

    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigation,
        actions = actions,
    )

}