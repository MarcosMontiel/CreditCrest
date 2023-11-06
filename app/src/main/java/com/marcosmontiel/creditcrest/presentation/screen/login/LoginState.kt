package com.marcosmontiel.creditcrest.presentation.screen.login

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

data class LoginState(
    // Email
    val email: String = "",
    val emailEnabled: Boolean = true,
    val emailEraser: Boolean = false,
    // Password
    val password: String = "",
    val passwordEnabled: Boolean = true,
    val passwordIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordTransformation: VisualTransformation = PasswordVisualTransformation(),
    // Validations
    val forgotPasswordButtonEnabled: Boolean = true,
    val informationFillCorrect: Boolean = false,
    val loginButtonEnabled: Boolean = true,
    val signUpButtonEnabled: Boolean = true,
)
