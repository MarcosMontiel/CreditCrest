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
import com.marcosmontiel.creditcrest.presentation.ui.theme.BlueGray900
import com.marcosmontiel.creditcrest.presentation.ui.theme.CreditCrestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var _navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val statusBarColor = if (isSystemInDarkTheme()) BlueGray900 else Blue500
            window.statusBarColor = statusBarColor.toArgb()

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