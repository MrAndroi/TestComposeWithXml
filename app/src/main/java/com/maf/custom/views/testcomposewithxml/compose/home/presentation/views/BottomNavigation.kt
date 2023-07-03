package com.maf.custom.views.testcomposewithxml.compose.home.presentation.views

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.home.presentation.model.BottomNavItem

@Composable
fun BottomNavigationView(navController: NavController) {
    val items = listOf(
        BottomNavItem.Discovery,
        BottomNavItem.Location,
        BottomNavItem.Cart,
        BottomNavItem.Favorites,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                selectedContentColor = Color(0xFFFE724C),
                unselectedContentColor = Color(0xFFD3D1D8),
                alwaysShowLabel = false,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}