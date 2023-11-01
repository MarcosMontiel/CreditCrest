package com.marcosmontiel.creditcrest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.creditcrest.presentation.navigation.Graph
import com.marcosmontiel.creditcrest.presentation.navigation.RootNavGraph
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundLightColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.CreditCrestTheme
import com.marcosmontiel.creditcrest.presentation.ui.theme.StatusBarLightColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var _navController: NavHostController
    private val _viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen: SplashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            val isDarkMode: Boolean = isSystemInDarkTheme()
            val sbColor = if (isDarkMode) BackgroundDarkColor else StatusBarLightColor
            val nbColor = if (isDarkMode) BackgroundDarkColor else BackgroundLightColor

            window.apply {
                statusBarColor = sbColor.toArgb()
                navigationBarColor = nbColor.toArgb()
            }

            CreditCrestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    // Graph navigation implementation
                    _navController = rememberNavController()
                    RootNavGraph(navController = _navController)

                    // Splash screen implementation
                    LaunchedEffect(Unit) {

                        if (_viewModel.currentUser != null) {

                            _navController.navigate(Graph.HOME) {
                                popUpTo(route = Graph.AUTHENTICATION) { inclusive = true }
                            }

                        }

                    }

                }
            }
        }

        splashScreen.setKeepOnScreenCondition { false }

    }

}