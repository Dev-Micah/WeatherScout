package com.micahnyabuto.weatherscout.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.micahnyabuto.weatherscout.Model.ModelCurrentWeatherResponse
import com.micahnyabuto.weatherscout.Model.forecast.ModelWeatherForecastResponse
import com.micahnyabuto.weatherscout.networkResp.NetworkResponse
import com.micahnyabuto.weatherscout.repository.CurrentWeatherRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val currentWeatherRepo: CurrentWeatherRepo): ViewModel() {
    private val _currentWeatherStatus = MutableLiveData<NetworkResponse<ModelCurrentWeatherResponse>>()
    val currentWeatherStatus: LiveData<NetworkResponse<ModelCurrentWeatherResponse>> = _currentWeatherStatus

    private val _forecastWeatherStatus = MutableLiveData<NetworkResponse<ModelWeatherForecastResponse>>()
    val forecastWeatherStatus: LiveData<NetworkResponse<ModelWeatherForecastResponse>> = _forecastWeatherStatus

    fun getWeatherData(city:String) {
        _currentWeatherStatus.postValue(NetworkResponse.Loading)
        viewModelScope.launch {
            currentWeatherRepo.getCurrentWeather(city).collect{modelCurrentWeatherResponse ->
                _currentWeatherStatus.postValue(modelCurrentWeatherResponse)
            }
        }
    }
}
//fun getForecastWeatherData(city:String){
//    _forecastWeatherStatus.postValue(NetworkResponse.Loading)
//    viewModelScope.launch {
//        currentWeatherRepo.getForecastWeather(city).collect{modelWeatherForecastResponse ->
//            _forecastWeatherStatus.postValue(modelWeatherForecastResponse)
//        }
//    }
//}