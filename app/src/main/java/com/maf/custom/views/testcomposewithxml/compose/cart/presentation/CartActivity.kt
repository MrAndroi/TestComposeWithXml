package com.maf.custom.views.testcomposewithxml.compose.cart.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views.MainCartScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {

    private val viewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                val state = viewModel.cartItemsState.collectAsState()
                state.value?.let {
                    MainCartScreen(
                        cartState = it,
                        onIntent = viewModel::onIntent
                    )
                }
            }
        }
        setUpObservers()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.cartIntent.collectLatest { cartIntent ->
                    when (cartIntent) {
                        is CartIntent.OnApplyPromoCodeClick -> {
                            Toast.makeText(
                                this@CartActivity,
                                "Code: ${cartIntent.promoCode}",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                        CartIntent.OnBackClick -> {
                            onBackPressedDispatcher.onBackPressed()
                        }

                        is CartIntent.OnCloseClickClick -> {
                            viewModel.removeCartItem(cartIntent.cartItem)
                        }

                        CartIntent.OnPlusMinusClick -> {
                            viewModel.getTotalPrice()
                        }
                    }
                }
            }
        }
    }
}