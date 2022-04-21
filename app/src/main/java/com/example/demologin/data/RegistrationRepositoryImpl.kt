package com.example.demologin.data

import com.example.demologin.data.network.ApiService
import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.RegistrationRepository
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(private val api: ApiService) :
    RegistrationRepository {

    override suspend fun getCoffees(): Result<List<Coffee>> {
        return try {
            Result.success(api.getCoffee())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}