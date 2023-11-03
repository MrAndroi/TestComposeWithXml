package com.maf.custom.views.testcomposewithxml.compose.loaction.presentation

import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.maf.custom.views.testcomposewithxml.compose.loaction.domain.LocationTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationTracker: LocationTracker
) : ViewModel() {

    var currentLocation by mutableStateOf<Location?>(null)
    var selectedLocation by mutableStateOf<LatLng?>(null)

    init {
        getCurrentLocation()
    }

    fun getCurrentLocation() = viewModelScope.launch {
        currentLocation = locationTracker.getCurrentLocation()
    }

    fun updateSelectedLocation(newLocation: LatLng) = viewModelScope.launch {
        selectedLocation = newLocation
    }

}