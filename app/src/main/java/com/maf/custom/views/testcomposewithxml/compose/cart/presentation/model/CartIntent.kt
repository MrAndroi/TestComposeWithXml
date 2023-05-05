package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel

sealed class CartIntent {
    object OnBackClick: CartIntent()
    object OnPlusMinusClick: CartIntent()
    data class OnCloseClickClick(val cartItem: CartModel): CartIntent()
    data class OnApplyPromoCodeClick(val promoCode: String): CartIntent()
}