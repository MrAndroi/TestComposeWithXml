package com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase

import com.maf.custom.views.testcomposewithxml.compose.cart.domain.CartRepository
import javax.inject.Inject

class GetCartItemsTotalPriceUseCase @Inject constructor(
    private val repository: CartRepository
) {

    operator fun invoke(): Float {
        return repository.getCartItemsTotalPrice()
    }
}