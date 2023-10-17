package com.marcosmontiel.creditcrest.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.navigation.HomeNavGraph

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            DefaultTopBar(title = stringResource(id = R.string.auth_login_title))

        },
        bottomBar = {

            HomeBottomBar(navController = navController)

        },
        content = {

            HomeNavGraph(navController = navController)

        },
    )

}