package com.maf.custom.views.testcomposewithxml.compose.home.presentation.model

import com.maf.custom.views.testcomposewithxml.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screen_route: String
) {
    object Discovery : BottomNavItem("", R.drawable.discovery_icon, "discovery")
    object Location : BottomNavItem("", R.drawable.location_icon, "location")
    object Cart : BottomNavItem("", R.drawable.cart_icon, "cart")
    object Favorites : BottomNavItem("", R.drawable.favourite_icon, "favorites")
    object Profile : BottomNavItem("", R.drawable.profile_icon, "profile")
}
