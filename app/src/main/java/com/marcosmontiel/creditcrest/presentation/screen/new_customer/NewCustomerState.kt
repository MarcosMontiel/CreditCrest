package com.marcosmontiel.creditcrest.presentation.screen.new_customer

data class NewCustomerState(
    val name: String = "",
    val nameEnabled: Boolean = true,
    val nameEraser: Boolean = false,
    val lastName: String = "",
    val lastNameEnabled: Boolean = true,
    val lastNameEraser: Boolean = false,
)
