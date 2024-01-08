package com.marcosmontiel.creditcrest.presentation.screen.customer

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultFloatingActionButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultIcon
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes.NewCustomer

@Composable
fun CustomerScreen(navController: NavHostController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {},
        floatingActionButton = {
            DefaultFloatingActionButton(
                content = {
                    DefaultIcon(
                        icon = Icons.Rounded.Add,
                        description = stringResource(R.string.customer_add_customer_icon),
                    )
                },
                click = { navController.navigate(NewCustomer.route) }
            )
        },
        content = {}
    )
}