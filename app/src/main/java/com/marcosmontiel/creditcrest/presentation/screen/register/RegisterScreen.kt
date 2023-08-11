package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultIconButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.screen.register.component.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            DefaultTopBar(
                icon = {

                    DefaultIconButton(
                        icon = Icons.Rounded.ArrowBack,
                        description = "pop back stack",
                        click = { navController.popBackStack() },
                    )

                },
                title = stringResource(R.string.signup_title_top_bar),
            )

        },
        bottomBar = {},
        content = { paddingValues ->

            RegisterContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                paddingValues = paddingValues,
            )

        }
    )

}