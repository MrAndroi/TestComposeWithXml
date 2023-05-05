package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views.DiscoveryFilterBottomSheet
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views.MainDiscoverScreen
import com.maf.custom.views.testcomposewithxml.navigation.Navigation
import com.maf.custom.views.testcomposewithxml.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@AndroidEntryPoint
class DiscoverActivity : AppCompatActivity() {

    private val viewModel: DiscoveryViewModel by viewModels()

    private lateinit var sheetState: BottomSheetState
    private lateinit var bottomSheetScaffoldState: BottomSheetScaffoldState
    private lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
                bottomSheetScaffoldState =
                    rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
                coroutineScope = rememberCoroutineScope()

                BottomSheetScaffold(
                    sheetContent = { DiscoveryFilterBottomSheet(viewModel::onIntent) },
                    sheetPeekHeight = 0.dp,
                    scaffoldState = bottomSheetScaffoldState,
                    sheetShape = RoundedCornerShape(20.dp),
                    sheetElevation = 20.dp,
                    sheetBackgroundColor = Color.Black,
                    sheetContentColor = Color.Black
                ) {
                    val state = viewModel.state.collectAsState()
                    state.value?.let {
                        MainDiscoverScreen(it, viewModel::onIntent)
                    }
                }
            }
        }
        setUpObservers()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            viewModel.discoveryIntent.collectLatest { discoveryIntent ->
                when (discoveryIntent) {
                    DiscoveryIntent.OnBackClick -> {
                        onBackPressedDispatcher.onBackPressed()
                    }

                    DiscoveryIntent.OnCartClick -> {
                        Navigation.navigateToScreen(Screen.CART_ACTIVITY, this@DiscoverActivity)
                    }

                    is DiscoveryIntent.OnFilterClick -> {
                        coroutineScope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }

                    is DiscoveryIntent.OnFilterItemClick -> {
                        Toast.makeText(
                            this@DiscoverActivity,
                            discoveryIntent.item,
                            Toast.LENGTH_SHORT
                        ).show()
                        coroutineScope.launch {
                            sheetState.collapse()
                        }
                    }

                    is DiscoveryIntent.OnFoodItemClick -> {
                        Navigation.navigateToScreen(
                            Screen.FOOD_DETAILS_ACTIVITY,
                            this@DiscoverActivity
                        )
                    }
                }
            }
        }
    }

}