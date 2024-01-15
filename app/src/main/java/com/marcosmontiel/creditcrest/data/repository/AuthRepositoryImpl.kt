package com.marcosmontiel.creditcrest.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.marcosmontiel.creditcrest.data.exception.FirebaseException
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.model.User
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(user: User): Response<FirebaseUser> {
        return try {
            val response = firebaseAuth.signInWithEmailAndPassword(
                user.email,
                user.password
            ).await()

            Response.Success(data = response.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(message = FirebaseException.message(e))
        }
    }

    override fun logout() = firebaseAuth.signOut()

    override suspend fun register(user: User): Response<FirebaseUser> {
        return try {
            val response = firebaseAuth.createUserWithEmailAndPassword(
                user.email,
                user.password
            ).await()

            Response.Success(data = response.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(message = FirebaseException.message(e))
        }
    }
}