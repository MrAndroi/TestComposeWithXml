package com.maf.custom.views.testcomposewithxml.compose.cart.data.locale

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel

object CartLocaleDataSource {

    private val cartModelOne = CartModel(
        name = "Red n hot pizza",
        description = "Spicy chicken, beef",
        image = "https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg?w=2000",
        price = 15.6f
    )

    private val cartModelTwo = CartModel(
        name = "Greek salad ",
        description = "with baked salmon",
        image = "https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg?w=2000",
        price = 12.0f
    )

    private val cartModelThree = CartModel(
        name = "Greek salad ",
        description = "with baked salmon",
        image = "https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg?w=2000",
        price = 12.0f
    )

    private val cartModelFour = CartModel(
        name = "Greek salad ",
        description = "with baked salmon",
        image = "https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg?w=2000",
        price = 12.0f
    )

    private val cartItems = mutableListOf(
        cartModelOne,
        cartModelTwo,
        cartModelThree,
        cartModelFour,
    )

    fun getCartItems(): List<CartModel> {
        return cartItems
    }

    fun removeCartItem(cartItem: CartModel) {
        cartItems.remove(cartItem)
    }

    fun getCartItemsPrice(): Float {
        var totalPrice = 0f
        cartItems.forEach { totalPrice += it.price * it.quantity }
        return totalPrice
    }
}