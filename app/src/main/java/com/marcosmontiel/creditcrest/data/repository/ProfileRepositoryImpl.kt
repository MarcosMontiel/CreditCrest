package com.marcosmontiel.creditcrest.data.repository

import com.google.firebase.firestore.CollectionReference
import com.marcosmontiel.creditcrest.core.Constants.PROFILES
import com.marcosmontiel.creditcrest.data.exception.FirebaseException
import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.model.User
import com.marcosmontiel.creditcrest.domain.repository.ProfileRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class ProfileRepositoryImpl @Inject constructor(
    @Named(PROFILES) private val profilesRef: CollectionReference
) : ProfileRepository {
    override suspend fun create(user: User): Response<Boolean> {
        return try {
            user.password = ""

            profilesRef.document(user.id).set(user).await()

            Response.Success(data = true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(message = FirebaseException.message(e))
        }
    }
}