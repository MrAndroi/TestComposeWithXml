package com.maf.custom.views.testcomposewithxml.compose.cart.data

import com.maf.custom.views.testcomposewithxml.compose.cart.data.locale.CartLocaleDataSource
import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(): CartRepository {

    override fun getCartItems(): List<CartModel> {
        return CartLocaleDataSource.getCartItems()
    }

    override fun removeCartItem(cartModel: CartModel) {
        return CartLocaleDataSource.removeCartItem(cartModel)
    }

    override fun getCartItemsTotalPrice(): Float {
        return CartLocaleDataSource.getCartItemsPrice()
    }
}