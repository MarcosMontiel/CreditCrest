package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes.Customer
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes.Finance
import com.marcosmontiel.creditcrest.presentation.screen.customer.CustomerScreen
import com.marcosmontiel.creditcrest.presentation.screen.finance.FinanceScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Finance.route,
        route = Graph.HOME
    ) {

        composable(route = Finance.route) {
            FinanceScreen()
        }

        composable(route = Customer.route) {
            CustomerScreen()
        }

    }
}

sealed class HomeRoutes(val icon: ImageVector, val title: String, val route: String) {

    object Finance : HomeRoutes(
        icon = Icons.Rounded.AttachMoney,
        title = "finanzas",
        route = "my_finance"
    )

    object Customer : HomeRoutes(
        icon = Icons.Rounded.Person,
        title = "clientes",
        route = "my_clients"
    )

}