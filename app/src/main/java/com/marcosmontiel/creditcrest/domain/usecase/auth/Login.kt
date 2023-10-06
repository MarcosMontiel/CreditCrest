package com.marcosmontiel.creditcrest.domain.usecase.auth

import com.google.firebase.auth.FirebaseUser
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Response<FirebaseUser> =
        repository.login(email = email, password = password)

}