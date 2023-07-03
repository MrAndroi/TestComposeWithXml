package com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.model

sealed class WelcomeIntent {
    object OnSignUpClick: WelcomeIntent()
    object OnSignInClick: WelcomeIntent()
}
