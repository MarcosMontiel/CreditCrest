package com.marcosmontiel.creditcrest.presentation.screen.register

import android.app.Application
import android.widget.Toast
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
import com.marcosmontiel.creditcrest.domain.model.User
import com.marcosmontiel.creditcrest.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val application: Application,
    private val authUseCases: AuthUseCases,
) : ViewModel() {

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
        val usernameValue: String = username.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        val emailValue: String = email.let {
            if (it.length > 50) it.slice(0 until 36) else it
        }

        val passwordValue: String = password.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        val passwordConfirmationValue: String = passwordConfirmation.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        registerState = registerState.copy(
            email = emailValue,
            emailEraser = emailValue.isNotBlank(),
            informationFillCorrect = usernameValue.isNotBlank() &&
                    emailValue.isNotBlank() &&
                    passwordValue.isNotBlank() &&
                    passwordConfirmationValue.isNotBlank(),
            password = passwordValue,
            passwordMatch = passwordValue == passwordConfirmationValue,
            passwordConfirmation = passwordConfirmationValue,
            username = usernameValue,
            usernameEraser = usernameValue.isNotBlank(),
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
        if (!registerState.informationFillCorrect) {
            val message = "Ingresa la información requerida para continuar."
            Toast.makeText(application.applicationContext, message, Toast.LENGTH_LONG).show()
            return
        }

        val user = User(
            email = registerState.email,
            password = registerState.password,
        )
        doRegister(user)
    }

    // Private functions

    private fun doRegister(user: User) = viewModelScope.launch {
        registerResponse = Response.Loading
        val response = authUseCases.register(user)
        registerResponse = response
    }

}