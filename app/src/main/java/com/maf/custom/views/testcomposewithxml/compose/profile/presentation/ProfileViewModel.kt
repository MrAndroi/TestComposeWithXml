package com.maf.custom.views.testcomposewithxml.compose.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.model.ProfileIntent
import com.maf.custom.views.testcomposewithxml.datastore.usecase.UpdateSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val updateSettingsUseCase: UpdateSettingsUseCase
): ViewModel() {

    private val _profileIntent = Channel<ProfileIntent>()
    val profileIntent = _profileIntent.consumeAsFlow()

    fun onIntent(intent: ProfileIntent) = viewModelScope.launch {
        _profileIntent.send(intent)
    }

    fun logOutUser() = viewModelScope.launch {
        updateSettingsUseCase(isLoggedIn = false)
        _profileIntent.send(ProfileIntent.SignOutUser)
    }
}