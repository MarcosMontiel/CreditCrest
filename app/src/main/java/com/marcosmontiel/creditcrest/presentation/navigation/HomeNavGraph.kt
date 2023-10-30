package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes.*
import com.marcosmontiel.creditcrest.presentation.screen.account.AccountScreen
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
            FinanceScreen(navController = navController)
        }

        composable(route = Customer.route) {
            CustomerScreen(navController = navController)
        }

        composable(route = Account.route) {
            AccountScreen(navController = navController)
        }

        detailsNavGraph(navController = navController)

    }

}

sealed class HomeRoutes(
    val icon: ImageVector,
    val title: String,
    val titleAlt: String,
    val route: String,
) {

    object Finance : HomeRoutes(
        icon = Icons.Rounded.AttachMoney,
        title = "finanzas",
        titleAlt = "Finanzas",
        route = "my_finance",
    )

    object Customer : HomeRoutes(
        icon = Icons.Rounded.Person,
        title = "clientes",
        titleAlt = "Clientes",
        route = "my_clients",
    )

    object Account : HomeRoutes(
        icon = Icons.Rounded.Menu,
        title = "cuenta",
        titleAlt = "Mi cuenta",
        route = "my_account",
    )

}