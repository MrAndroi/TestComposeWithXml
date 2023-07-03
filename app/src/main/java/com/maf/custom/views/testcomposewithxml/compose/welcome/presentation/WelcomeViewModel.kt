package com.maf.custom.views.testcomposewithxml.compose.welcome.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.model.WelcomeIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(): ViewModel() {

    private val _welcomeIntent = Channel<WelcomeIntent>()
    val welcomeIntent = _welcomeIntent.receiveAsFlow()

    fun onIntent(intent: WelcomeIntent) = viewModelScope.launch {
        _welcomeIntent.send(intent)
    }
}