package com.micahnyabuto.weatherscout.Model.forecast

import android.location.Location
import com.micahnyabuto.weatherscout.Model.Current

data class ModelWeatherForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)
