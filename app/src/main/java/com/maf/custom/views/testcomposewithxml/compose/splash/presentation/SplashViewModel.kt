package com.maf.custom.views.testcomposewithxml.compose.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.datastore.usecase.GetSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getSettingsUseCase: GetSettingsUseCase
): ViewModel() {

    private val _userLoggedInStateFlow = MutableStateFlow<Boolean?>(null)
    val userLoggedInStateFlow = _userLoggedInStateFlow.asStateFlow()

    init {
        getUserLoggedInState()
    }

    private fun getUserLoggedInState() = viewModelScope.launch {
        _userLoggedInStateFlow.emit(getSettingsUseCase().loggedInUser)
    }

}