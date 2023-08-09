package com.marcosmontiel.creditcrest.presentation.screen.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.presentation.screen.login.component.LoginContent

@Composable
fun LoginScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {},
        content = { paddingValues ->

            LoginContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                paddingValues = paddingValues,
            )

        },
    )

}