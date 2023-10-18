package com.marcosmontiel.creditcrest.presentation.screen.settings.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun SettingsContent(
    modifier: Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    Text(text = "Settings")
}