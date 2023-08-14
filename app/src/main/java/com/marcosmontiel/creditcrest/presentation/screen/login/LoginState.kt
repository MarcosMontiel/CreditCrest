package com.marcosmontiel.creditcrest.presentation.screen.login

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

data class LoginState(
    val email: String = "",
    val emailEraser: Boolean = false,
    val password: String = "",
    val passwordIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordTransformation: VisualTransformation = PasswordVisualTransformation(),
)
