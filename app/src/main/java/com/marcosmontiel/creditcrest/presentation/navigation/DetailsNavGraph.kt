package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes.Settings
import com.marcosmontiel.creditcrest.presentation.screen.settings.SettingsScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(startDestination = Settings.route, route = Graph.DETAILS) {

        composable(route = Settings.route) {
            SettingsScreen(navController = navController)
        }

    }

}

sealed class DetailsRoutes(val route: String) {

    object Settings : DetailsRoutes(route = "settings")

}