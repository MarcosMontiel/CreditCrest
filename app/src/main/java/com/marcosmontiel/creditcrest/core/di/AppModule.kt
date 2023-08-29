package com.marcosmontiel.creditcrest.core.di

import com.google.firebase.auth.FirebaseAuth
import com.marcosmontiel.creditcrest.data.repository.AuthRepositoryImpl
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import com.marcosmontiel.creditcrest.domain.usecase.auth.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Firebase Auth
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    // Repositories

    @Provides
    @Singleton
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    // Use cases

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases =
        AuthUseCases(
            currentUser = GetCurrentUser(repository),
            login = Login(repository),
            logout = Logout(repository),
            register = Register(repository),
        )

}