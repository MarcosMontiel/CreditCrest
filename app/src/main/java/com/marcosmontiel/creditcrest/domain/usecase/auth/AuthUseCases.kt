package com.marcosmontiel.creditcrest.domain.usecase.auth

data class AuthUseCases(
    val currentUser: GetCurrentUser,
    val login: Login,
    val logout: Logout,
    val register: Register,
)
