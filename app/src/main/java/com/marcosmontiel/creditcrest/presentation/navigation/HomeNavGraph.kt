package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "", route = "") {

    }
}

sealed class HomeRoutes(val icon: ImageVector, val title: String, val route: String) {

}