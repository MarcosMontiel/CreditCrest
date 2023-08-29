package com.marcosmontiel.creditcrest.domain.usecase.auth

import com.marcosmontiel.creditcrest.domain.model.User
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import javax.inject.Inject

class Register @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.register(user = user)

}