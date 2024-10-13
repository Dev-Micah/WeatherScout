package com.micahnyabuto.weatherscout.repository

import com.micahnyabuto.weatherscout.Model.ModelCurrentWeatherResponse
import com.micahnyabuto.weatherscout.Model.forecast.ModelWeatherForecastResponse
import com.micahnyabuto.weatherscout.api.ApiService
import com.micahnyabuto.weatherscout.networkResp.NetworkResponse
import com.micahnyabuto.weatherscout.utility.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrentWeatherRepo @Inject constructor(val apiService: ApiService) {
    suspend fun getCurrentWeather(city: String): Flow<NetworkResponse<ModelCurrentWeatherResponse>> = flow{
        val response = apiService.getCurrentWeather(Constants.apiKey, city)

        if(response.isSuccessful){
            emit(NetworkResponse.Success(response.body()!!))
        }else{
            emit(NetworkResponse.Error(response.errorBody().toString()))
        }
    }.catch {e->
        emit(NetworkResponse.Error(e.message.toString()))
    }
    suspend fun getForecastWeather(city: String): Flow<NetworkResponse<ModelWeatherForecastResponse>> =
        flow {
            val response = apiService.getForecastWeather(Constants.apiKey,city)
            if(response.isSuccessful){
                emit(NetworkResponse.Success(response.body()!!))
            }else{
                emit(NetworkResponse.Error(response.errorBody().toString()))

            }
        }
}