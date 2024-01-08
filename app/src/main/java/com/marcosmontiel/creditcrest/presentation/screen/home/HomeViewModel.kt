package com.marcosmontiel.creditcrest.presentation.screen.home

import android.app.Activity
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundDarkColor
import com.marcosmontiel.creditcrest.presentation.ui.theme.BackgroundLightColor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    // Functions
    fun setUIColors(isDarkMode: Boolean, context: Context) {
        val color: Color = if (isDarkMode) BackgroundDarkColor else BackgroundLightColor
        val activity: Activity = context as Activity

        activity.window.apply {
            statusBarColor = color.toArgb()
            navigationBarColor = color.toArgb()
        }
    }
}