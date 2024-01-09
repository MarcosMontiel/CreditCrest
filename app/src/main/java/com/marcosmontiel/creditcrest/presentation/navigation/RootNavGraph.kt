package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosmontiel.creditcrest.presentation.screen.home.HomeScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT,
    ) {
        authNavGraph(navController = navController)

        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}