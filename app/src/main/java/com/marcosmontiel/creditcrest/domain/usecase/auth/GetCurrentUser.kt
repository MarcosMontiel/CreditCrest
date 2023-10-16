package com.marcosmontiel.creditcrest.domain.usecase.auth

import com.google.firebase.auth.FirebaseUser
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(): FirebaseUser? = repository.currentUser

}