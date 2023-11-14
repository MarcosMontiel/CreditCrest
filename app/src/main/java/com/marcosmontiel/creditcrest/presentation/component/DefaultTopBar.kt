package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundLightColor

@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigation: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    background: Color = if (isSystemInDarkTheme()) BackgroundDarkColor else BackgroundLightColor
) {

    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigation,
        actions = actions,
        backgroundColor = background,
    )

}