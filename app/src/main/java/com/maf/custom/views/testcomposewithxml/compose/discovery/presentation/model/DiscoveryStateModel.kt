package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model

sealed class DiscoveryStateModel {
    object Loading: DiscoveryStateModel()
    data class Success(val data: String): DiscoveryStateModel()
    data class Error(val message: String) : DiscoveryStateModel()
}
