package com.maf.custom.views.testcomposewithxml.compose.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase.GetCartItemsTotalPriceUseCase
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase.GetCartItemsUseCase
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.usecase.RemoveCartItemUseCase
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartStateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val removeCartItemUseCase: RemoveCartItemUseCase,
    private val getCartItemsTotalPriceUseCase: GetCartItemsTotalPriceUseCase
): ViewModel() {

    private val _cartItemsState = MutableStateFlow<CartStateModel?>(null)
    val cartItemsState = _cartItemsState.asStateFlow()

    private val _cartIntent = Channel<CartIntent>()
    val cartIntent = _cartIntent.receiveAsFlow()

    init {
        getCartItems()
    }

    fun onIntent(intent: CartIntent) = viewModelScope.launch {
        _cartIntent.send(intent)
    }

    private fun getCartItems() = viewModelScope.launch {
        _cartItemsState.value = CartStateModel.Loading
        try {
            delay(2000)
            _cartItemsState.value = CartStateModel.Success(getCartItemsUseCase(), getCartItemsTotalPriceUseCase())
        } catch (e: Exception) {
            _cartItemsState.value = CartStateModel.Error(e.message!!)
        }
    }

    fun removeCartItem(cartModel: CartModel) = viewModelScope.launch {
        _cartItemsState.value = CartStateModel.Loading
        try {
            delay(1000)
            removeCartItemUseCase(cartModel)
            _cartItemsState.value = CartStateModel.Success(getCartItemsUseCase(), getCartItemsTotalPriceUseCase())
        } catch (e: Exception) {
            _cartItemsState.value = CartStateModel.Error(e.message!!)
        }
    }

    fun getTotalPrice() = viewModelScope.launch {
        _cartItemsState.value = CartStateModel.Success(getCartItemsUseCase(), getCartItemsTotalPriceUseCase())
    }

}