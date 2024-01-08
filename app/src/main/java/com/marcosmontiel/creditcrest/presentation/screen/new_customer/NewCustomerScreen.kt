package com.marcosmontiel.creditcrest.presentation.screen.new_customer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultBackButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.component.NewCustomerContent
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.component.NewCustomerView

@Composable
fun NewCustomerScreen(navController: NavHostController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DefaultTopBar(
                title = { DefaultText(title = stringResource(R.string.customer_screen_title)) },
                navigation = { DefaultBackButton(navController = navController) }
            )
        },
        bottomBar = {},
        content = {
            NewCustomerContent(modifier = Modifier.fillMaxSize())

            NewCustomerView(modifier = Modifier.fillMaxSize(), navController = navController)
        }
    )
}