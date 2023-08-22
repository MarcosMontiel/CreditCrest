package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

data class RegisterState(
    val email: String = "",
    val emailEnabled: Boolean = true,
    val emailEraser: Boolean = false,
    val password: String = "",
    val passwordEnabled: Boolean = true,
    val passwordIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordTransformation: VisualTransformation = PasswordVisualTransformation(),
    val passwordConfirmation: String = "",
    val passwordConfirmationEnabled: Boolean = true,
    val passwordConfirmationIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordConfirmationTransformation: VisualTransformation = PasswordVisualTransformation(),
    val signUpButtonEnabled: Boolean = true,
    val username: String = "",
    val usernameEnabled: Boolean = false,
    val usernameEraser: Boolean = false,
)
