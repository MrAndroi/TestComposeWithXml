package com.maf.custom.views.testcomposewithxml.compose.welcome.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.model.WelcomeIntent
import com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.views.WelcomeScreen
import com.maf.custom.views.testcomposewithxml.navigation.Navigation.navigateToScreen
import com.maf.custom.views.testcomposewithxml.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WelcomeActivity: AppCompatActivity() {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                WelcomeScreen(viewModel::onIntent)
            }
        }
        setUpObservers()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.welcomeIntent.collectLatest { intent ->
                    when(intent) {
                        WelcomeIntent.OnSignInClick -> {

                        }
                        WelcomeIntent.OnSignUpClick -> {
                            navigateToScreen(
                                screen = Screen.SIGN_UP_ACTIVITY,
                                navigateAndRemoveFromStack = true
                            )
                        }
                    }
                }
            }
        }
    }
}