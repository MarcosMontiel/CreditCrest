package com.marcosmontiel.creditcrest.domain.repository

import com.marcosmontiel.creditcrest.domain.model.Customer
import com.marcosmontiel.creditcrest.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun create(customer: Customer): Response<Boolean>

    fun getCustomers(): Flow<Response<List<Customer>>>

}