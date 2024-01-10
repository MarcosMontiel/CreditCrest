package com.marcosmontiel.creditcrest.presentation.screen.login.component

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.presentation.component.DefaultProgressIndicator
import com.marcosmontiel.creditcrest.presentation.navigation.Graph
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel

@Composable
fun LoginView(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val loginResponse = viewModel.loginResponse

    Box(modifier = modifier) {
        loginResponse.let { stateFlow ->
            when (stateFlow) {
                Response.Loading -> {
                    DefaultProgressIndicator()
                }

                is Response.Failure -> {
                    viewModel.enableForm()

                    val message: String = stateFlow.message
                        ?: stringResource(R.string.generic_unknown_exception_title)
                    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG)
                        .apply { show() }
                }

                is Response.Success -> {
                    LaunchedEffect(Unit) {
                        viewModel.loginResponse = null

                        navController.navigate(route = Graph.HOME) {
                            popUpTo(route = Graph.AUTHENTICATION) { inclusive = true }
                        }
                    }
                }

                else -> {}
            }
        }
    }
}