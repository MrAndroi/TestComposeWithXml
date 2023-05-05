package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartStateModel
import com.maf.custom.views.testcomposewithxml.compose.shared.model.DataStateModel
import com.maf.custom.views.testcomposewithxml.compose.shared.views.HeaderSection

@Composable
fun MainCartScreen(
    cartState: CartStateModel,
    onIntent: ((CartIntent) -> Unit) = { }
) {
    Surface {
        when (cartState) {
            CartStateModel.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            is CartStateModel.Error -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = cartState.message,
                        fontSize = 45.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.Bold)),
                    )
                }
            }

            is CartStateModel.Success -> {
                val cartItems = cartState.data
                if (cartItems.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Cart is empty",
                            fontSize = 45.sp,
                            fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.Bold)),
                        )
                    }
                } else {
                    Column(modifier = Modifier
                        .fillMaxSize()
                    ) {
                        LazyColumn {
                            item {
                                HeaderSection(
                                    title = "Cart",
                                    showTitle = true,
                                    onBackClick = { onIntent(CartIntent.OnBackClick) }
                                )
                            }
                            items(cartItems.size) {
                                val cartItem = cartItems[it]
                                CartItem(cartItem, onIntent)
                            }
                            item {
                                ApplyPromoCodeSection(onIntent)
                                Spacer(modifier = Modifier.height(20.dp))
                                CartTotalSection(
                                    totalItems = cartItems.size,
                                    totalPrice = cartState.totalPrice
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                        }

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainCartScreenPreview() {
    MainCartScreen(
        CartStateModel.Success(
            data = listOf(
                CartModel(
                    name = "Red n hot pizza",
                    description = "Spicy chicken, beef",
                    image = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/216054.jpg",
                    price = 15.6f
                )
            ),
            totalPrice = 20f
        )
    )
}