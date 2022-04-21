package com.example.demologin.injection

import com.example.demologin.data.RegistrationRepositoryImpl
import com.example.demologin.data.network.ApiService
import com.example.demologin.domain.RegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(FragmentComponent::class)
abstract class Modules {
    @Binds
    abstract fun provideRegistrationRepository(registrationRepositoryImpl: RegistrationRepositoryImpl): RegistrationRepository
}

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