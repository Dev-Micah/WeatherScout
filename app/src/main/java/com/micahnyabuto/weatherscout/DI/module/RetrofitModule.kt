package com.micahnyabuto.weatherscout.DI.module

import android.content.Context
import com.google.android.libraries.places.api.net.PlacesClient
import com.micahnyabuto.weatherscout.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
   fun provideRetrofit(): Retrofit {
       return Retrofit.Builder()
           .baseUrl("https://api.weatherapi.com")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}