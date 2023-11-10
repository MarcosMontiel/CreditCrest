package com.marcosmontiel.creditcrest.domain.usecase.customer

import com.marcosmontiel.creditcrest.domain.model.Customer
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.repository.CustomerRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: CustomerRepository) {

    suspend operator fun invoke(customer: Customer): Response<Boolean> =
        repository.create(customer = customer)

}