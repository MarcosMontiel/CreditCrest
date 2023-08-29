package com.marcosmontiel.creditcrest.domain.usecase.auth

import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.logout()

}