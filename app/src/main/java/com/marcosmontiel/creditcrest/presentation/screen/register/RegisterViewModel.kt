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
import com.marcosmontiel.creditcrest.domain.usecase.profile.ProfileUseCases
import com.marcosmontiel.creditcrest.presentation.enum.PasswordStrength
import com.marcosmontiel.creditcrest.presentation.enum.PasswordStrength.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val application: Application,
    private val authUseCases: AuthUseCases,
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {

    // Password instances
    private var _showPassword: Boolean = false
    private var _showPasswordConfirmation: Boolean = false
    private val _passHiddenIcon: ImageVector = Icons.Rounded.VisibilityOff
    private val _passHiddenMask: VisualTransformation = PasswordVisualTransformation()
    private val _passVisibleIcon: ImageVector = Icons.Rounded.Visibility
    private val _passVisibleMask: VisualTransformation = VisualTransformation.None

    // Late init variables
    private lateinit var _userInfo: User

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
            passwordStrength = measurePasswordStrength(passwordValue),
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

    fun enableForm() {
        registerState = registerState.copy(
            emailEnabled = true,
            loginButtonEnabled = true,
            passwordEnabled = true,
            passwordConfirmationEnabled = true,
            signUpButtonEnabled = true,
            usernameEnabled = true,
        )
    }

    fun signUp() {
        if (!registerState.informationFillCorrect) {
            val message = "Ingresa la información requerida para continuar"
            Toast.makeText(application.applicationContext, message, Toast.LENGTH_LONG).show()
            return
        }
        if (registerState.password.length < 8) {
            val message = "La contraseña debe tener al menos 8 caracteres"
            Toast.makeText(application.applicationContext, message, Toast.LENGTH_LONG).show()
            return
        }
        if (!registerState.passwordMatch) {
            val message = "Las contraseñas que ingresaste no coinciden"
            Toast.makeText(application.applicationContext, message, Toast.LENGTH_LONG).show()
            return
        }

        _userInfo = User(
            email = registerState.email,
            password = registerState.password,
            username = registerState.username,
        )

        signUpAction()
    }

    fun createProfile() = viewModelScope.launch {
        if (!::_userInfo.isInitialized) return@launch

        _userInfo.id = authUseCases.currentUser()?.uid ?: return@launch
        profileUseCases.create(user = _userInfo)
    }

    // Private functions
    private fun measurePasswordStrength(password: String, minLength: Int = 8): PasswordStrength {
        val containsUppercase = password.contains(Regex(buildString {
            append("[A-Z]")
        }))

        val containsLowercase = password.contains(Regex(buildString {
            append("[a-z]")
        }))

        val containsDigits = password.contains(Regex(buildString {
            append("[0-9]")
        }))

        val containsSpecialChars = password.contains(Regex(buildString {
            append("[!@#\$%^&*()-_+=<>?]")
        }))

        val meetsLengthRequirement = password.length >= minLength
        val meetsRequirements =
            containsUppercase && containsLowercase && containsDigits && containsSpecialChars

        return when {
            password.isBlank() -> EMPTY
            meetsLengthRequirement && meetsRequirements -> STRONG
            meetsLengthRequirement || meetsRequirements -> MEDIUM
            else -> WEAK
        }
    }

    private fun signUpAction() = viewModelScope.launch {
        if (!::_userInfo.isInitialized) return@launch

        disableForm()

        registerResponse = Response.Loading
        val response = authUseCases.register(_userInfo)
        registerResponse = response
    }

    private fun disableForm() {
        registerState = registerState.copy(
            emailEnabled = false,
            loginButtonEnabled = false,
            passwordEnabled = false,
            passwordConfirmationEnabled = false,
            signUpButtonEnabled = false,
            usernameEnabled = false,
        )
    }

}