package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.CartViewModel

@Composable
fun CartRoute(
    viewModel: CartViewModel
) {
    val state = viewModel.cartItemsState.collectAsStateWithLifecycle()
    CartScreen(cartState = state.value, onIntent = viewModel::onIntent)
}