package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue800
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray200

@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    background: Color = Blue800,
    title: String,
) {

    TopAppBar(
        title = { DefaultText(color = Gray200, title = title) },
        modifier = modifier,
        navigationIcon = icon,
        actions = actions,
        backgroundColor = background,
        elevation = 8.dp,
    )

}