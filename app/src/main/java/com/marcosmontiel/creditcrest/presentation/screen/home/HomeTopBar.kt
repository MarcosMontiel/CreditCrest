package com.marcosmontiel.creditcrest.presentation.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultIconButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes

@Composable
fun HomeTopBar(navController: NavHostController, screens: List<HomeRoutes>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topBarDestination = screens.any { it.route == currentDestination?.route }

    if (topBarDestination) {

        DefaultTopBar(
            actions = {

                DefaultIconButton(
                    icon = Icons.Rounded.MoreVert,
                    description = stringResource(R.string.generic_settings_icon),
                ) {
                    navController.navigate(route = DetailsRoutes.Settings.route)
                }

            },
            title = stringResource(id = R.string.auth_login_title),
        )

    }

}