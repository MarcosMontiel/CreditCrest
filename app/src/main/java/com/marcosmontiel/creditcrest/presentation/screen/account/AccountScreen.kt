package com.marcosmontiel.creditcrest.presentation.screen.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.presentation.screen.account.component.AccountContent

@Composable
fun AccountScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {},
        content = {

            AccountContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )

        },
    )

}