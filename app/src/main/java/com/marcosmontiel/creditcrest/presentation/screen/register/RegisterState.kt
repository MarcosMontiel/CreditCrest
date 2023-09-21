package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.marcosmontiel.creditcrest.presentation.enum.PasswordStrength

data class RegisterState(
    val email: String = "",
    val emailEnabled: Boolean = true,
    val emailEraser: Boolean = false,
    val informationFillCorrect: Boolean = false,
    val loginButtonEnabled: Boolean = true,
    val password: String = "",
    val passwordEnabled: Boolean = true,
    val passwordIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordMatch: Boolean = true,
    val passwordStrength: PasswordStrength = PasswordStrength.EMPTY,
    val passwordTransformation: VisualTransformation = PasswordVisualTransformation(),
    val passwordConfirmation: String = "",
    val passwordConfirmationEnabled: Boolean = true,
    val passwordConfirmationIcon: ImageVector = Icons.Rounded.Visibility,
    val passwordConfirmationTransformation: VisualTransformation = PasswordVisualTransformation(),
    val signUpButtonEnabled: Boolean = true,
    val username: String = "",
    val usernameEnabled: Boolean = true,
    val usernameEraser: Boolean = false,
)
