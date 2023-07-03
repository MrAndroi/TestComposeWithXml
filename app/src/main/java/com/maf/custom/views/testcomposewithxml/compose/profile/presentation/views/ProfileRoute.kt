package com.maf.custom.views.testcomposewithxml.compose.profile.presentation.views

import androidx.compose.runtime.Composable
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.ProfileViewModel

@Composable
fun ProfileRoute(
    viewModel: ProfileViewModel
) {
    ProfileScreen(viewModel::onIntent)
}