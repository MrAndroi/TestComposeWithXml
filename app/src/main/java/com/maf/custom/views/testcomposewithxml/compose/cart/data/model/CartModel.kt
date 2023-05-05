package com.maf.custom.views.testcomposewithxml.compose.cart.data.model


data class CartModel(
    val name: String,
    val description: String,
    var quantity: Int = 0,
    val price: Float,
    val image: String,
)
