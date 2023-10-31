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

}