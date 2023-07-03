package com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model

sealed class SignUpErrorState{
    object Email: SignUpErrorState()
    object FullName: SignUpErrorState()
    object Password: SignUpErrorState()
    object None: SignUpErrorState()
}
