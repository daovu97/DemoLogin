package com.example.demologin.injection

import com.example.demologin.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Provider {

    @Provides
    fun provideRetrofit(@AuthInterceptorClient okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}