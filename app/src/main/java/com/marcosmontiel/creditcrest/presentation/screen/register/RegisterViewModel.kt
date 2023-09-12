package com.marcosmontiel.creditcrest.presentation.screen.register

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
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.marcosmontiel.creditcrest.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    // Password instances
    private var _showPassword: Boolean = false
    private var _showPasswordConfirmation: Boolean = false
    private val _passHiddenIcon: ImageVector = Icons.Rounded.VisibilityOff
    private val _passHiddenMask: VisualTransformation = PasswordVisualTransformation()
    private val _passVisibleIcon: ImageVector = Icons.Rounded.Visibility
    private val _passVisibleMask: VisualTransformation = VisualTransformation.None

    // State
    var registerState by mutableStateOf(RegisterState())
        private set

    // Response
    var registerResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    // Events
    fun valueChanged(
        email: String,
        password: String,
        passwordConfirmation: String,
        username: String,
    ) {
        val emailValue: String = email.let {
            if (it.length > 50) it.slice(0 until 36) else it
        }

        val passwordValue: String = password.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        val passwordConfirmationValue: String = passwordConfirmation.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }
        val usernameValue: String = username.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        registerState = registerState.copy(
            email = emailValue,
            emailEraser = emailValue.isNotEmpty() && emailValue.isNotBlank(),
            password = passwordValue,
            passwordConfirmation = passwordConfirmationValue,
            username = usernameValue,
            usernameEraser = usernameValue.isNotEmpty() && usernameValue.isNotBlank(),
        )
    }

    fun emailEraser() {
        registerState = registerState.copy(
            email = "",
            emailEraser = false,
        )
    }

    fun usernameEraser() {
        registerState = registerState.copy(
            username = "",
            usernameEraser = false,
        )
    }

    fun passwordTransformation() {
        _showPassword = !_showPassword

        registerState = registerState.copy(
            passwordIcon = if (_showPassword) _passHiddenIcon else _passVisibleIcon,
            passwordTransformation = if (_showPassword) _passVisibleMask else _passHiddenMask
        )
    }

    fun passwordConfirmationTransformation() {
        _showPasswordConfirmation = !_showPasswordConfirmation

        registerState = registerState.copy(
            passwordConfirmationIcon = if (_showPasswordConfirmation) _passHiddenIcon else _passVisibleIcon,
            passwordConfirmationTransformation = if (_showPasswordConfirmation) _passVisibleMask else _passHiddenMask
        )
    }

    fun register() {
        doRegister()
    }

    // Private functions

    private fun doRegister() = viewModelScope.launch {
        registerResponse = Response.Loading
    }

}