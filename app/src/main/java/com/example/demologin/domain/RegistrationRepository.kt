package com.example.demologin.domain

import com.example.demologin.data.response.Coffee
import com.example.demologin.domain.entity.UserEntity

interface RegistrationRepository {
    suspend fun getCoffees(): Result<List<Coffee>>
}