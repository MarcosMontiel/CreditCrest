package com.marcosmontiel.creditcrest.domain.repository

import com.marcosmontiel.creditcrest.domain.model.Customer
import com.marcosmontiel.creditcrest.domain.model.Response

interface CustomerRepository {

    suspend fun create(customer: Customer): Response<Boolean>

}