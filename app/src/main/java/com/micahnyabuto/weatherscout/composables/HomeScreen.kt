package com.micahnyabuto.weatherscout.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.micahnyabuto.weatherscout.R

import com.micahnyabuto.weatherscout.viewModel.PlaceViewModel
import com.micahnyabuto.weatherscout.viewModel.WeatherViewModel

             
@Composable
fun HomeScreen(
    weatherViewModel: WeatherViewModel,
    placeViewModel: PlaceViewModel,
    currentTime: Int
){
    val currentWeatherStatus =weatherViewModel.currentWeatherStatus.observeAsState()
    val selectedPlace by placeViewModel.selectedPlace.collectAsState()

    var placeName by remember { mutableStateOf("*") }

    selectedPlace?.let { place->
        if(!placeName.equals(place)){
            Log.d("sss","homeScreen: city = $place")
            placeName = selectedPlace!!
            weatherViewModel.getWeatherData(placeName)
            weatherViewModel.getForecastWeatherData(placeName)
        }

    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        if (selectedPlace!=null){
            Image(painter = painterResource(id = R.drawable.night_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(
                        radiusX = 40.dp,
                        radiusY = 40.dp
                    )
                )
        }else{

        }

    }

}