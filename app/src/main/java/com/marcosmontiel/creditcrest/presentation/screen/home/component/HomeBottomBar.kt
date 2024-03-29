package com.marcosmontiel.creditcrest.presentation.screen.home.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marcosmontiel.creditcrest.presentation.component.DefaultIcon
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundLightColor

@Composable
fun HomeBottomBar(navController: NavHostController, screens: List<HomeRoutes>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    val isDarkMode: Boolean = isSystemInDarkTheme()
    val backgroundColor: Color = if (isDarkMode) BackgroundDarkColor else BackgroundLightColor

    if (bottomBarDestination) {
        BottomNavigation(backgroundColor = backgroundColor) {
            screens.forEach { screen ->
                AddItemToBottomBar(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItemToBottomBar(
    screen: HomeRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(route = screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = { DefaultIcon(icon = screen.icon, description = "${screen.route} navigation icon") },
        label = { DefaultText(title = screen.title) },
        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.disabled),
    )
}