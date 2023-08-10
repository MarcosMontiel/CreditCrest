package com.marcosmontiel.creditcrest.presentation.screen.login

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    // Password instances
    private var _showPassword: Boolean = false
    private val _passHiddenIcon: ImageVector = Icons.Rounded.VisibilityOff
    private val _passHiddenMask: VisualTransformation = PasswordVisualTransformation()
    private val _passVisibleIcon: ImageVector = Icons.Rounded.Visibility
    private val _passVisibleMask: VisualTransformation = VisualTransformation.None

    // State
    var loginState by mutableStateOf(LoginState())
        private set

    // Events
    fun valueChanged(email: String, password: String) {
        val emailValue: String = email.let {
            if (it.length > 50) it.slice(0 until 50) else it
        }

        val passValue: String = password.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        loginState = loginState.copy(
            email = emailValue,
            password = passValue,
        )
    }

    fun visualPasswordChanged() {
        _showPassword = !_showPassword

        loginState = loginState.copy(
            passwordIcon = if (_showPassword) _passHiddenIcon else _passVisibleIcon,
            passwordTransformation = if (_showPassword) _passVisibleMask else _passHiddenMask
        )
    }

}