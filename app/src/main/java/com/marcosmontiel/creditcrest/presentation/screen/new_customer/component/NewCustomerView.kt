package com.marcosmontiel.creditcrest.presentation.screen.new_customer.component

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
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.NewCustomerViewModel

@Composable
fun NewCustomerView(
    modifier: Modifier,
    viewModel: NewCustomerViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val newCustomerResponse = viewModel.newCustomerResponse

    Box(modifier = modifier) {
        newCustomerResponse.let { stateFlow ->
            when (stateFlow) {
                Response.Loading -> {

                    DefaultProgressIndicator()

                }

                is Response.Failure -> {

                    viewModel.enableForm()

                    val message: String = stateFlow.message
                        ?: stringResource(R.string.generic_unknown_exception_title)
                    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()

                }

                is Response.Success -> {

                    LaunchedEffect(Unit) {

                        viewModel.newCustomerResponse = null

                        navController.popBackStack()

                    }

                }

                else -> {}
            }
        }
    }
}