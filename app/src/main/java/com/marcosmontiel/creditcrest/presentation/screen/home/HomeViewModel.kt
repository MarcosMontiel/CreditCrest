package com.marcosmontiel.creditcrest.presentation.screen.home

import android.app.Activity
import android.content.Context
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.NavigationBarDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.NavigationBarLightColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.StatusBarDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.StatusBarLightColor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    // Functions
    fun setUIColors(isSystemInDarkTheme: Boolean, context: Context) {
        val sbColor = if (isSystemInDarkTheme) StatusBarDarkColor else StatusBarLightColor
        val nbColor = if (isSystemInDarkTheme) NavigationBarDarkColor else NavigationBarLightColor
        val activity: Activity = context as Activity

        activity.window.apply {
            statusBarColor = sbColor.toArgb()
            navigationBarColor = nbColor.toArgb()
        }
    }

}