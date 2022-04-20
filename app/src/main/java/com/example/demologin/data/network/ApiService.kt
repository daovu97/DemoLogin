package com.example.demologin.data.network

import com.example.demologin.data.response.Coffee
import retrofit2.http.GET


interface ApiService {

    @GET("coffee/hot")
    suspend fun getCoffee(): List<Coffee>
}