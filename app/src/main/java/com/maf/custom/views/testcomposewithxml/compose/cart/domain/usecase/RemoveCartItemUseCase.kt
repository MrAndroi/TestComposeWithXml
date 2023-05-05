package com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase

import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.CartRepository
import javax.inject.Inject

class RemoveCartItemUseCase @Inject constructor(
    private val repository: CartRepository
) {

    operator fun invoke(cartModel: CartModel) {
        return repository.removeCartItem(cartModel)
    }
}