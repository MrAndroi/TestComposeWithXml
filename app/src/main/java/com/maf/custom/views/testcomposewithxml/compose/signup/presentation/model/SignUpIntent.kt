package com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model

sealed class SignUpIntent {
    data class OnSignUpClick(val fullName: String, val email: String, val password: String): SignUpIntent()
    object SignInUser: SignUpIntent()
}