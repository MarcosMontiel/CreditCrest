package com.marcosmontiel.creditcrest.presentation.screen.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    // State
    var registerState by mutableStateOf(RegisterState())
        private set

    // Events
    fun valueChanged(
        email: String,
        password: String,
        passwordConfirmation: String,
        username: String,
    ) {
        val emailValue: String = email.let {
            if (it.length > 50) it.slice(0 until 50) else it
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
            password = passwordValue,
            passwordConfirmation = passwordConfirmationValue,
            username = usernameValue,
        )
    }

}