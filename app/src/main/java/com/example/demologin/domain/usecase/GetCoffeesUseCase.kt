package com.example.demologin.domain.usecase

import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.RegistrationRepository
import com.example.demologin.domain.entity.UserEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class GetCoffeesUseCase @Inject constructor(private val registrationRepository: RegistrationRepository) {
    suspend fun invoke() : Result<List<Coffee>>  {
       return registrationRepository.getCoffees()
    }
}