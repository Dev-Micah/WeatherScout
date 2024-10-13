package com.micahnyabuto.weatherscout.Model

import android.location.Location

data class ModelCurrentWeatherResponse(
    val current: Current,
    val location: Location
)
