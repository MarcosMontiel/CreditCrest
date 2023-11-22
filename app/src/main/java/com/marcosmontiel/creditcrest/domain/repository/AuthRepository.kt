package com.marcosmontiel.creditcrest.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.model.User

interface AuthRepository {

    val currentUser: FirebaseUser?

    suspend fun login(user: User): Response<FirebaseUser>

    fun logout()

    suspend fun register(user: User): Response<FirebaseUser>

}