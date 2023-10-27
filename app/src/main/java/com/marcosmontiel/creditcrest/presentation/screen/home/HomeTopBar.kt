package com.marcosmontiel.creditcrest.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes

@Composable
fun HomeTopBar(navController: NavHostController, screens: List<HomeRoutes>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topBarDestination = screens.any { it.route == currentDestination?.route }

    if (topBarDestination) {

        val screen = screens.find { it.route == currentDestination?.route } ?: return

        DefaultTopBar(title = { DefaultText(title = screen.titleAlt) })

    }

}