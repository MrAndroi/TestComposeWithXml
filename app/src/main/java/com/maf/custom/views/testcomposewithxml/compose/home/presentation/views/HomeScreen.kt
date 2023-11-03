package com.maf.custom.views.testcomposewithxml.compose.home.presentation.views

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.CartViewModel
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.DiscoveryViewModel
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.ProfileViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    bottomSheetState: BottomSheetState,
    discoveryViewModel: DiscoveryViewModel,
    cartViewModel: CartViewModel,
    profileViewModel: ProfileViewModel,
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomSheetState.isCollapsed,
                enter = expandIn(),
                exit = shrinkOut()
            ) {
                BottomNavigationView(navController = navController)
            }
        }
    ) {
        NavigationGraph(
            navController = navController,
            sheetState = bottomSheetState,
            discoveryViewModel = discoveryViewModel,
            cartViewModel = cartViewModel,
            profileViewModel = profileViewModel
        )
    }
}