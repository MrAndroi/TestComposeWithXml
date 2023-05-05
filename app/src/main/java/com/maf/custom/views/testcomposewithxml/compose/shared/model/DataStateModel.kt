package com.maf.custom.views.testcomposewithxml.compose.shared.model

sealed class DataStateModel {
    object Loading: DataStateModel()
    data class Success<T>(val data: T): DataStateModel()
    data class Error(val message: String) : DataStateModel()
}
