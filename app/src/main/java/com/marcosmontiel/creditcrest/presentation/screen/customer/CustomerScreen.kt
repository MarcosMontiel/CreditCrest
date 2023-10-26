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
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar

@Composable
fun CustomerScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            DefaultTopBar(title = { DefaultText(title = stringResource(R.string.customer_title)) })

        },
        bottomBar = {},
        floatingActionButton = {

            DefaultFloatingActionButton(
                content = {

                    DefaultIcon(
                        icon = Icons.Rounded.Add,
                        description = stringResource(R.string.customer_add_customer_icon),
                    )

                },
                click = {}
            )

        },
        content = {},
    )

}