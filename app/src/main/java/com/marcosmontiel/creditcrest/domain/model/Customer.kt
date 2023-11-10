package com.marcosmontiel.creditcrest.domain.model

import java.util.UUID

data class Customer(
    var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var lastname: String = "",
    var curp: String = "",
    var userId: String = "",
)
