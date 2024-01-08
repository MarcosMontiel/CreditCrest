package com.marcosmontiel.creditcrest.presentation.screen.new_customer

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosmontiel.creditcrest.domain.model.Customer
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.usecase.auth.AuthUseCases
import com.marcosmontiel.creditcrest.domain.usecase.customer.CustomerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewCustomerViewModel @Inject constructor(
    private val application: Application,
    private val authUseCases: AuthUseCases,
    private val customerUseCases: CustomerUseCases
) : ViewModel() {
    // Late init variables
    private lateinit var _customerInfo: Customer

    // State
    var newCustomerState by mutableStateOf(NewCustomerState())
        private set

    // Response
    var newCustomerResponse by mutableStateOf<Response<Boolean>?>(null)

    // Events
    fun valueChanged(name: String, lastName: String, curp: String) {
        val nameValue: String = name.let {
            if (it.length > 30) it.slice(0 until 30) else it
        }

        val lastNameValue: String = lastName.let {
            if (it.length > 30) it.slice(0 until 30) else it
        }

        val curpValue: String = curp.let {
            if (it.length > 18) it.slice(0 until 18) else it
        }

        newCustomerState = newCustomerState.copy(
            name = nameValue,
            nameEraser = nameValue.isNotEmpty() && nameValue.isNotBlank(),
            lastName = lastNameValue,
            lastNameEraser = lastNameValue.isNotEmpty() && lastNameValue.isNotBlank(),
            curp = curpValue,
            curpCorrect = curpValue.length == 18,
            curpEraser = curpValue.isNotEmpty() && curpValue.isNotBlank(),
            informationFillCorrect = nameValue.isNotBlank() && lastNameValue.isNotBlank() && curpValue.isNotBlank(),
        )
    }

    fun nameEraser() {
        newCustomerState = newCustomerState.copy(
            name = "",
            nameEraser = false,
        )
    }

    fun lastNameEraser() {
        newCustomerState = newCustomerState.copy(
            lastName = "",
            lastNameEraser = false,
        )
    }

    fun curpEraser() {
        newCustomerState = newCustomerState.copy(
            curp = "",
            curpCorrect = false,
            curpEraser = false,
        )
    }

    fun enableForm() {
        newCustomerState = newCustomerState.copy(
            nameEnabled = true,
            lastNameEnabled = true,
            curpEnabled = true,
            saveButtonEnabled = true,
        )

        newCustomerResponse = null
    }

    fun createCustomer() {
        val message: String? = when {
            !newCustomerState.informationFillCorrect -> "Ingresa la información requerida para continuar"

            newCustomerState.curp.length < 8 -> "El CURP debe tener 18 caracteres"

            else -> null
        }

        message?.let {
            Toast.makeText(application.applicationContext, it, Toast.LENGTH_LONG)
                .apply { show() }
                .also { return }
        }

        _customerInfo = Customer(
            name = newCustomerState.name.trim(),
            lastname = newCustomerState.lastName.trim(),
            curp = newCustomerState.curp.trim(),
        )

        createCustomerAction()
    }

    // Private functions
    private fun createCustomerAction() = viewModelScope.launch {
        if (!::_customerInfo.isInitialized) return@launch

        disableForm()

        _customerInfo.userId = authUseCases.currentUser()?.uid ?: return@launch

        newCustomerResponse = Response.Loading
        val response = customerUseCases.create(customer = _customerInfo)
        newCustomerResponse = response
    }

    private fun disableForm() {
        newCustomerState = newCustomerState.copy(
            nameEnabled = false,
            lastNameEnabled = false,
            curpEnabled = false,
            saveButtonEnabled = false,
        )
    }
}