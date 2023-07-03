package com.maf.custom.views.testcomposewithxml.compose.home.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.CartViewModel
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.DiscoveryViewModel
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.home.presentation.views.HomeScreen
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.ProfileViewModel
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.model.ProfileIntent
import com.maf.custom.views.testcomposewithxml.navigation.Navigation.navigateToScreen
import com.maf.custom.views.testcomposewithxml.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var bottomSheetState: BottomSheetState
    private lateinit var coroutineScope: CoroutineScope

    private val discoveryViewModel: DiscoveryViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
            coroutineScope = rememberCoroutineScope()

            MdcTheme {
                HomeScreen(
                    bottomSheetState = bottomSheetState,
                    discoveryViewModel = discoveryViewModel,
                    cartViewModel = cartViewModel,
                    profileViewModel = profileViewModel
                )
            }
        }
        setUpObservers()
    }

    private fun setUpObservers() {
        //Discovery events
        lifecycleScope.launch {
            discoveryViewModel.discoveryIntent.collectLatest { discoveryIntent ->
                when (discoveryIntent) {
                    DiscoveryIntent.OnBackClick -> {
                        onBackPressedDispatcher.onBackPressed()
                    }

                    is DiscoveryIntent.OnFilterClick -> {
                        coroutineScope.launch {
                            if (bottomSheetState.isCollapsed) {
                                bottomSheetState.expand()
                            } else {
                                bottomSheetState.collapse()
                            }
                        }
                    }

                    is DiscoveryIntent.OnFilterItemClick -> {
                        Toast.makeText(
                            this@HomeActivity,
                            discoveryIntent.item,
                            Toast.LENGTH_SHORT
                        ).show()
                        coroutineScope.launch {
                            bottomSheetState.collapse()
                        }
                    }

                    is DiscoveryIntent.OnFoodItemClick -> {
                        navigateToScreen(Screen.FOOD_DETAILS_ACTIVITY)
                    }
                }
            }
        }

        //Cart events
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                cartViewModel.cartIntent.collectLatest { cartIntent ->
                    when (cartIntent) {
                        is CartIntent.OnApplyPromoCodeClick -> {
                            Toast.makeText(
                                this@HomeActivity,
                                "Code: ${cartIntent.promoCode}",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                        CartIntent.OnBackClick -> {
                            onBackPressedDispatcher.onBackPressed()
                        }

                        is CartIntent.OnCloseClickClick -> {
                            cartViewModel.removeCartItem(cartIntent.cartItem)
                        }

                        CartIntent.OnPlusMinusClick -> {
                            cartViewModel.getTotalPrice()
                        }
                    }
                }
            }
        }

        //Profile events
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                profileViewModel.profileIntent.collect { profileIntent ->
                    when (profileIntent) {
                        ProfileIntent.OnMoreClick -> {
                            profileViewModel.logOutUser()
                        }

                        ProfileIntent.SignOutUser -> {
                            navigateToScreen(
                                Screen.WELCOME_ACTIVITY,
                                navigateAndRemoveFromStack = true
                            )
                        }
                    }
                }
            }
        }
    }
}