package com.maf.custom.views.testcomposewithxml.compose.cart.domain

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel

interface CartRepository {
    fun getCartItems(): List<CartModel>
    fun removeCartItem(cartModel: CartModel)
    fun getCartItemsTotalPrice(): Float
}