package com.marcosmontiel.creditcrest.presentation.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

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

}