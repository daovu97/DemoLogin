package com.example.demologin.data

import android.util.Log
import com.example.demologin.data.network.ApiService
import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.RegistrationRepository
import com.example.demologin.domain.entity.UserEntity
import java.lang.Exception
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(private val api: ApiService) :
    RegistrationRepository {

    override suspend fun getCoffees(): List<Coffee> {
        return try {
            api.getCoffee()
        } catch (e: Exception) {
            Log.d("D", e.localizedMessage)
            emptyList()
        }
    }
}