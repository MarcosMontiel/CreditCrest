package com.marcosmontiel.creditcrest.presentation.screen.login.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.presentation.component.DefaultSolidBackground
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue800

@Composable
fun LoginContent(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    Box(modifier = modifier) {

        DefaultSolidBackground(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(fraction = 0.45f),
            color = Blue800,
        )

    }

}