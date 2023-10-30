package com.marcosmontiel.creditcrest.presentation.screen.home

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.creditcrest.presentation.navigation.HomeNavGraph
import com.marcosmontiel.creditcrest.presentation.navigation.HomeRoutes.*

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val screens = listOf(Finance, Customer, Account)
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val isDarkMode: Boolean = isSystemInDarkTheme()
    val context: Context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.setUIColors(isDarkMode, context)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            HomeTopBar(
                navController = navController,
                screens = screens,
            )

        },
        bottomBar = {

            HomeBottomBar(
                navController = navController,
                screens = screens,
            )

        },
        content = {

            HomeNavGraph(navController = navController)

        },
    )

}