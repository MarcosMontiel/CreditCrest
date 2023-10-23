package com.marcosmontiel.creditcrest.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.creditcrest.presentation.navigation.HomeNavGraph
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes.*

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val screens = listOf(Finance, Customer, Account)
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {

            HomeBottomBar(navController = navController, screens = screens)

        },
        content = {

            HomeNavGraph(navController = navController)

        },
    )

}