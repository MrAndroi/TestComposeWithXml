package com.maf.custom.views.testcomposewithxml.compose.home.presentation.views

import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.CartViewModel
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views.CartRoute
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views.CartScreen
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.DiscoveryViewModel
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views.DiscoveryRoute
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views.DiscoveryScreen
import com.maf.custom.views.testcomposewithxml.compose.home.presentation.model.BottomNavItem
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.ProfileViewModel
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.views.ProfileRoute
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.views.ProfileScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    sheetState: BottomSheetState,
    discoveryViewModel: DiscoveryViewModel,
    cartViewModel: CartViewModel,
    profileViewModel: ProfileViewModel,
) {

    NavHost(navController, startDestination = BottomNavItem.Discovery.screen_route) {
        composable(BottomNavItem.Discovery.screen_route) {
            DiscoveryRoute(sheetState = sheetState, viewModel = discoveryViewModel)
        }
        composable(BottomNavItem.Location.screen_route) {
        }
        composable(BottomNavItem.Cart.screen_route) {
            CartRoute(viewModel = cartViewModel)
        }
        composable(BottomNavItem.Favorites.screen_route) {
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileRoute(viewModel = profileViewModel)
        }
    }

}