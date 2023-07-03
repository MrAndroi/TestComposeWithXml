package com.maf.custom.views.testcomposewithxml.compose.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.compose.signup.domain.usecase.ValidateSignUpFormUseCase
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpErrorState
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpIntent
import com.maf.custom.views.testcomposewithxml.datastore.usecase.UpdateSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    val validateSignUpFormUseCase: ValidateSignUpFormUseCase,
    val updateSettingsUseCase: UpdateSettingsUseCase
) : ViewModel() {

    private val _signUpIntent = Channel<SignUpIntent>()
    val signUpIntent = _signUpIntent.receiveAsFlow()

    private val _signUpErrorState = Channel<SignUpErrorState>()
    val signUpErrorState = _signUpErrorState.receiveAsFlow()

    fun onIntent(intent: SignUpIntent) = viewModelScope.launch {
        _signUpIntent.send(intent)
    }

    fun submitSignUpForm(
        fullName: String,
        email: String,
        password: String,
    ) = viewModelScope.launch {
        val error = validateSignUpFormUseCase(fullName, email, password)
        if(error is SignUpErrorState.None) {
            loginUser(fullName, email)
            _signUpIntent.send(SignUpIntent.SignInUser)
        } else {
            _signUpErrorState.send(error)
        }
    }

    private fun loginUser(
        fullName: String,
        email: String,
    ) = viewModelScope.launch {
        updateSettingsUseCase(
            accessToken = "test",
            refreshToken = "sda",
            isLoggedIn = true,
            userName = fullName,
            userEmail = email,
        )
    }
}