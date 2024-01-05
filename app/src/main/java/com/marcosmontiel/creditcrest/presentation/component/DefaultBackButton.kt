package com.marcosmontiel.creditcrest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray200
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray900

@Composable
fun DefaultBackButton(navController: NavHostController) {
    Box(modifier = Modifier.padding(start = 16.dp)) {
        DefaultIconButton(
            modifier = Modifier
                .background(
                    color = if (isSystemInDarkTheme()) Gray200 else Gray900,
                    shape = CircleShape
                )
                .size(24.dp),
            color = if (isSystemInDarkTheme()) Gray900 else Gray200,
            icon = Icons.Rounded.ChevronLeft,
            description = stringResource(R.string.generic_pop_back_stack_icon),
            click = { navController.popBackStack() }
        )
    }
}