package com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.CartRepository
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(
    private val repository: CartRepository
) {

    operator fun invoke(): List<CartModel> {
        return repository.getCartItems()
    }
}