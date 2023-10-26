package com.marcosmontiel.creditcrest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.creditcrest.presentation.navigation.RootNavGraph
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue500
import com.marcosmontiel.creditcrest.presentation.ui.theme.CreditCrestTheme
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray100
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray900
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var _navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val isDarkMode: Boolean = isSystemInDarkTheme()
            val sbColor = if (isDarkMode) Gray900 else Blue500
            val nbColor = if (isDarkMode) Gray900 else Gray100

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

                    _navController = rememberNavController()
                    RootNavGraph(navController = _navController)

                }
            }
        }

    }

}