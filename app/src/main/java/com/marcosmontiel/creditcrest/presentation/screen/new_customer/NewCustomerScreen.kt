package com.marcosmontiel.creditcrest.presentation.screen.new_customer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultIconButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.component.NewCustomerContent

@Composable
fun NewCustomerScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            DefaultTopBar(
                title = { DefaultText(title = stringResource(R.string.customer_screen_title)) },
                navigation = {

                    DefaultIconButton(
                        icon = Icons.Rounded.ArrowBackIosNew,
                        description = stringResource(R.string.generic_pop_back_stack_icon),
                        click = { navController.popBackStack() }
                    )

                }
            )

        },
        bottomBar = {},
        content = {

            NewCustomerContent(modifier = Modifier.fillMaxSize())

        },
    )

}