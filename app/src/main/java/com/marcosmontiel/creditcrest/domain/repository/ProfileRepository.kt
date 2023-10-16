package com.marcosmontiel.creditcrest.domain.repository

import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.model.User

interface ProfileRepository {

    suspend fun create(user: User): Response<Boolean>

}