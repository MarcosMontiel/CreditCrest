package com.marcosmontiel.creditcrest.presentation.screen.new_customer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewCustomerViewModel @Inject constructor() : ViewModel() {

    // State
    var newCustomerState by mutableStateOf(NewCustomerState())
        private set

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

}