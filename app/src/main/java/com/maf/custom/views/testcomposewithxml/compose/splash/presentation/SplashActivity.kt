package com.maf.custom.views.testcomposewithxml.compose.splash.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.splash.presentation.views.SplashScreen
import com.maf.custom.views.testcomposewithxml.navigation.Navigation.navigateToScreen
import com.maf.custom.views.testcomposewithxml.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val userLoggedInState = viewModel.userLoggedInStateFlow.collectAsState()

            LaunchedEffect(key1 = true) {
                coroutineScope.launch {
                    delay(2000)
                    if(userLoggedInState.value == true) {
                        navigateToScreen(
                            screen = Screen.HOME_ACTIVITY,
                            navigateAndRemoveFromStack = true
                        )
                    } else {
                        navigateToScreen(
                            screen = Screen.WELCOME_ACTIVITY,
                            navigateAndRemoveFromStack = true,
                        )
                    }
                }
            }
            MdcTheme {
                SplashScreen()
            }
        }
    }
}