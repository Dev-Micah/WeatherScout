package com.micahnyabuto.weatherscout.api

import com.micahnyabuto.weatherscout.Model.ModelCurrentWeatherResponse
import com.micahnyabuto.weatherscout.Model.forecast.ModelWeatherForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("/v1/current.json")
    suspend fun getCurrentWeather(
        @Query("q") apiKey: String,
        @Query("key") city: String
    ): Response<ModelCurrentWeatherResponse>
    @GET("/v1/forecast.json")
    suspend fun getForecastWeather(
        @Query("q") apiKey: String,
        @Query("key") city: String
    ): Response<ModelWeatherForecastResponse>


}