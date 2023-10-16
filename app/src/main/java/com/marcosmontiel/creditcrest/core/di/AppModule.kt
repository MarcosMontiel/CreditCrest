package com.marcosmontiel.creditcrest.core.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.marcosmontiel.creditcrest.core.Constants.PROFILES
import com.marcosmontiel.creditcrest.data.repository.AuthRepositoryImpl
import com.marcosmontiel.creditcrest.data.repository.ProfileRepositoryImpl
import com.marcosmontiel.creditcrest.domain.repository.AuthRepository
import com.marcosmontiel.creditcrest.domain.repository.ProfileRepository
import com.marcosmontiel.creditcrest.domain.usecase.auth.*
import com.marcosmontiel.creditcrest.domain.usecase.profile.Create
import com.marcosmontiel.creditcrest.domain.usecase.profile.ProfileUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Firebase Auth
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    // Firebase Firestore
    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    @Named(PROFILES)
    fun provideProfilesRef(database: FirebaseFirestore): CollectionReference =
        database.collection(PROFILES)

    // Repositories
    @Provides
    @Singleton
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    @Singleton
    fun provideProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository = impl

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

    @Provides
    @Singleton
    fun provideProfileUseCases(repository: ProfileRepository): ProfileUseCases =
        ProfileUseCases(
            create = Create(repository)
        )

}