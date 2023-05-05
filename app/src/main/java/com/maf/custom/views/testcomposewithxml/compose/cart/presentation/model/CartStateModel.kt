package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel

sealed class CartStateModel {
    object Loading: CartStateModel()
    data class Success(val data: List<CartModel>, val totalPrice: Float): CartStateModel()
    data class Error(val message: String) : CartStateModel()
}
