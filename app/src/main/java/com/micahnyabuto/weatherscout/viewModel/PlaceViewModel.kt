package com.micahnyabuto.weatherscout.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.micahnyabuto.weatherscout.repository.placeRepo.PlaceRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PlaceViewModel@Inject constructor(
private val placeRepo: PlaceRepo
) : ViewModel(){
    private val _predictions = MutableStateFlow<List<AutocompletePrediction>>(emptyList())
    val predictions : StateFlow<List<AutocompletePrediction>>get() = _predictions

    private val _selectedPlace = MutableStateFlow<String?>(null)
    val selectedPlace : StateFlow<String?>get() = _selectedPlace

    fun getPredictions(query: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                placeRepo.findAutoCompletePlacePredictions(query).collect{ placeLists ->
                    _predictions.value = placeLists
                }

            }
        }
    }
    fun fetchPlaceDetails(placeId: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                placeRepo.findCityName(placeId).collect { place ->
                    Log.d("TAG","findPlaceLatLong: place lat long is ${place}")
                    _selectedPlace.value = place
                }
            }
        }
    }
}