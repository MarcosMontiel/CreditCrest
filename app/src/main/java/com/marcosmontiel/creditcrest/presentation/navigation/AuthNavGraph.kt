package com.marcosmontiel.creditcrest.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes.Login
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes.Register
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginScreen
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = Login.route, route = Graph.AUTHENTICATION) {
        composable(route = Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Register.route) {
            RegisterScreen(navController = navController)
        }
    }
}

sealed class AuthRoutes(val route: String) {
    object Login : AuthRoutes(route = "login")

    object Register : AuthRoutes(route = "register")
}