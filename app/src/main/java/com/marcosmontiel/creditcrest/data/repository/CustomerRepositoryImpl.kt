package com.marcosmontiel.creditcrest.data.repository

import com.google.firebase.firestore.CollectionReference
import com.marcosmontiel.creditcrest.core.Constants.CUSTOMERS
import com.marcosmontiel.creditcrest.data.exception.FirebaseException
import com.marcosmontiel.creditcrest.domain.model.Customer
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class CustomerRepositoryImpl @Inject constructor(
    @Named(CUSTOMERS) private val customerRef: CollectionReference
) : CustomerRepository {
    override suspend fun create(customer: Customer): Response<Boolean> {
        return try {
            customerRef.add(customer).await()

            Response.Success(data = true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(message = FirebaseException.message(e))
        }
    }

    override fun getCustomers(): Flow<Response<List<Customer>>> {
        TODO("Not yet implemented")
    }
}