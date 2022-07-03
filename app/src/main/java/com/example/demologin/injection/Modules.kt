package com.example.demologin.injection

import com.example.demologin.data.RegistrationRepository
import com.example.demologin.data.RegistrationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface Modules {
    @Binds
    fun provideRegistrationRepository(registrationRepositoryImpl: RegistrationRepositoryImpl): RegistrationRepository
}