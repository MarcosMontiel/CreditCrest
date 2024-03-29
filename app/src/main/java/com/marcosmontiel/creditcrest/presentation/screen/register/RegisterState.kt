package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.marcosmontiel.creditcrest.presentation.enum.PasswordStrength

data class RegisterState(
    // Username
    val username: String = "",
    val usernameEnabled: Boolean = true,
    val usernameEraser: Boolean = false,
    // Email
    val email: String = "",
    val emailEnabled: Boolean = true,
    val emailEraser: Boolean = false,
    // Password
    val password: String = "",
    val passwordEnabled: Boolean = true,
    val passwordIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordMatch: Boolean = true,
    val passwordStrength: PasswordStrength = PasswordStrength.EMPTY,
    val passwordTransformation: VisualTransformation = PasswordVisualTransformation(),
    // Password confirmation
    val passwordConfirmation: String = "",
    val passwordConfirmationEnabled: Boolean = true,
    val passwordConfirmationIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordConfirmationTransformation: VisualTransformation = PasswordVisualTransformation(),
    // Validations
    val informationFillCorrect: Boolean = false,
    val loginButtonEnabled: Boolean = true,
    val signUpButtonEnabled: Boolean = true,
)
