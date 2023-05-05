package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryStateModel
import com.maf.custom.views.testcomposewithxml.compose.shared.model.DataStateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoveryViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<DiscoveryStateModel?>(null)
    val state = _state.asStateFlow()

    private val _discoveryIntent = Channel<DiscoveryIntent>()
    val discoveryIntent = _discoveryIntent.receiveAsFlow()

    init {
        loadData()
    }

    fun onIntent(discoveryIntent: DiscoveryIntent) = viewModelScope.launch {
        _discoveryIntent.send(discoveryIntent)
    }

    private fun loadData() = viewModelScope.launch {
        _state.value = DiscoveryStateModel.Loading
        try {
            delay(3000)
            _state.value = DiscoveryStateModel.Success("Some data")
        } catch (e: Exception) {
            _state.value = DiscoveryStateModel.Error(e.message!!)
        }
    }
}