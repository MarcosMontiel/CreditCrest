package com.marcosmontiel.creditcrest.presentation.screen.new_customer

data class NewCustomerState(
    // Name
    val name: String = "",
    val nameEnabled: Boolean = true,
    val nameEraser: Boolean = false,
    // Last name
    val lastName: String = "",
    val lastNameEnabled: Boolean = true,
    val lastNameEraser: Boolean = false,
    // C.U.R.P.
    val curp: String = "",
    val curpCorrect: Boolean = false,
    val curpEnabled: Boolean = true,
    val curpEraser: Boolean = false,
)
