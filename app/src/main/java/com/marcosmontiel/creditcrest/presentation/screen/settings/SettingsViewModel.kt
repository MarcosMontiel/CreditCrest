package com.marcosmontiel.creditcrest.presentation.screen.settings

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.presentation.enum.ActionSettings
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes.SettingsAccount
import com.marcosmontiel.creditcrest.presentation.navigation.DetailsRoutes.SettingsHelp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    // Events
    fun chooseActions(action: ActionSettings, navController: NavHostController) {
        when (action) {
            ActionSettings.ACCOUNT -> {
                navController.navigate(SettingsAccount.route)
            }

            ActionSettings.HELP -> {
                navController.navigate(SettingsHelp.route)
            }
        }
    }
}