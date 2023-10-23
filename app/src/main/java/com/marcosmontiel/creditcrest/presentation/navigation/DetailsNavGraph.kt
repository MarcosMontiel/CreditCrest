package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(startDestination = "", route = Graph.DETAILS) {

    }

}

sealed class DetailsRoutes(val route: String) {

}