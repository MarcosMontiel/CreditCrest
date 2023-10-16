package com.marcosmontiel.creditcrest.domain.usecase.profile

import com.marcosmontiel.creditcrest.domain.model.Response
import com.marcosmontiel.creditcrest.domain.model.User
import com.marcosmontiel.creditcrest.domain.repository.ProfileRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: ProfileRepository) {

    suspend operator fun invoke(user: User): Response<Boolean> = repository.create(user = user)

}