package com.maf.custom.views.testcomposewithxml.compose.signup.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpErrorState
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpIntent
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.views.SignUpScreen
import com.maf.custom.views.testcomposewithxml.navigation.Navigation.navigateToScreen
import com.maf.custom.views.testcomposewithxml.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpActivity: AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val errorState = viewModel.signUpErrorState.collectAsState(initial = SignUpErrorState.None)
            MdcTheme {
                SignUpScreen(
                    onIntent = viewModel::onIntent,
                    signUpErrorState = errorState.value
                )
            }
            setUpObservers()
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            viewModel.signUpIntent.collectLatest { intent ->
                when(intent) {
                    is SignUpIntent.OnSignUpClick -> {
                        viewModel.submitSignUpForm(
                            fullName = intent.fullName,
                            email = intent.email,
                            password = intent.password
                        )
                    }

                    SignUpIntent.SignInUser -> {
                        navigateToScreen(
                            Screen.HOME_ACTIVITY,
                            navigateAndRemoveFromStack = true
                        )
                    }
                }
            }
        }
    }
}