package com.marcosmontiel.creditcrest.presentation.screen.register.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.presentation.component.DefaultProgressIndicator
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterViewModel

@Composable
fun RegisterView(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val registerResponse = viewModel.registerResponse

    Box(modifier = modifier) {
        registerResponse.let { stateFlow ->
            when (stateFlow) {
                Response.Loading -> {

                    DefaultProgressIndicator()

                }

                is Response.Failure -> {}

                is Response.Success -> {}

                else -> {}
            }
        }
    }
}