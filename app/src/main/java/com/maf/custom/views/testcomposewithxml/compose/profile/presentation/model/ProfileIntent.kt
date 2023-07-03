package com.maf.custom.views.testcomposewithxml.compose.profile.presentation.model

sealed class ProfileIntent{
    object OnMoreClick: ProfileIntent()
    object SignOutUser: ProfileIntent()
}
