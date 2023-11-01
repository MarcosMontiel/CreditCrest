package com.marcosmontiel.creditcrest.presentation.screen.login

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
import com.marcosmontiel.creditcrest.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val application: Application,
    private val authUseCases: AuthUseCases,
) : ViewModel() {

    // Password instances
    private var _showPassword: Boolean = false
    private val _passHiddenIcon: ImageVector = Icons.Rounded.VisibilityOff
    private val _passHiddenMask: VisualTransformation = PasswordVisualTransformation()
    private val _passVisibleIcon: ImageVector = Icons.Rounded.Visibility
    private val _passVisibleMask: VisualTransformation = VisualTransformation.None

    // Current user data
    val currentUser: FirebaseUser? = authUseCases.currentUser()

    // State
    var loginState by mutableStateOf(LoginState())
        private set

    // Response
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    // Events
    fun valueChanged(email: String, password: String) {
        val emailValue: String = email.let {
            if (it.length > 50) it.slice(0 until 50) else it
        }

        val passwordValue: String = password.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        loginState = loginState.copy(
            email = emailValue,
            emailEraser = emailValue.isNotEmpty() && emailValue.isNotBlank(),
            informationFillCorrect = emailValue.isNotBlank() && passwordValue.isNotBlank(),
            password = passwordValue,
        )
    }

    fun emailEraser() {
        loginState = loginState.copy(
            email = "",
            emailEraser = false,
        )
    }

    fun passwordTransformation() {
        _showPassword = !_showPassword

        loginState = loginState.copy(
            passwordIcon = if (_showPassword) _passHiddenIcon else _passVisibleIcon,
            passwordTransformation = if (_showPassword) _passVisibleMask else _passHiddenMask
        )
    }

    fun enableForm() {
        loginState = loginState.copy(
            emailEnabled = true,
            loginButtonEnabled = true,
            passwordEnabled = true,
            signUpButtonEnabled = true,
        )
    }

    fun login() {
        if (!loginState.informationFillCorrect) {
            val message = "Ingresa la información requerida para continuar"
            Toast.makeText(application.applicationContext, message, Toast.LENGTH_LONG).show()
            return
        }

        doLogin()
    }

    // Private functions
    private fun doLogin() = viewModelScope.launch {
        disableForm()

        loginResponse = Response.Loading
        val response = authUseCases.login(email = loginState.email, password = loginState.password)
        loginResponse = response
    }

    private fun disableForm() {
        loginState = loginState.copy(
            emailEnabled = false,
            loginButtonEnabled = false,
            passwordEnabled = false,
            signUpButtonEnabled = false,
        )
    }

}