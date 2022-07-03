package com.example.demologin.data

import com.example.demologin.data.response.Coffee

interface RegistrationRepository {
    suspend fun getCoffees(): Result<List<Coffee>>
}