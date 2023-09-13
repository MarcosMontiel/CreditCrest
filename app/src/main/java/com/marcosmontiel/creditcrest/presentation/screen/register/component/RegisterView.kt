package com.marcosmontiel.creditcrest.presentation.screen.register.component

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

                is Response.Failure -> {

                    val message: String = stateFlow.exception?.message ?: "unknown exception"
                    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()

                }

                is Response.Success -> {}

                else -> {}
            }
        }
    }
}