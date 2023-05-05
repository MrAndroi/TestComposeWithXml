package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model


sealed class DiscoveryIntent {
    object OnBackClick: DiscoveryIntent()
    object OnCartClick: DiscoveryIntent()
    object OnFilterClick: DiscoveryIntent()
    data class OnFoodItemClick(val position: Int, val name: String): DiscoveryIntent()
    data class OnFilterItemClick(val item: String): DiscoveryIntent()
}
