package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes.NewCustomer
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.NewCustomerScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(startDestination = NewCustomer.route, route = Graph.DETAILS) {

        composable(route = NewCustomer.route) {
            NewCustomerScreen(navController = navController)
        }

    }

}

sealed class DetailsRoutes(val route: String) {

    object NewCustomer : DetailsRoutes(route = "my_clients/add")

}