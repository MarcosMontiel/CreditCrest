package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.presentation.screen.register.component.RegisterContent
import com.marcosmontiel.creditcrest.presentation.screen.register.component.RegisterView

@Composable
fun RegisterScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {},
        content = { paddingValues ->

            RegisterContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                paddingValues = paddingValues,
            )

        }
    )

    RegisterView(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
    )

}