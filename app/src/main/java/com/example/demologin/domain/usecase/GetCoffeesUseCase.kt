package com.example.demologin.domain.usecase

import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.RegistrationRepository
import javax.inject.Inject


class GetCoffeesUseCase @Inject constructor(private val registrationRepository: RegistrationRepository,
): BaseUseCase<List<Coffee>>() {

    internal override suspend fun handleData(): Result<List<Coffee>> {
        return registrationRepository.getCoffees()
    }
}

abstract class BaseUseCase<T>() {
    open suspend fun invoke() : Result<T>  {
        return handleData()
    }

   internal abstract suspend fun handleData() : Result<T>
}