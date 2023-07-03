package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.DiscoveryViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DiscoveryRoute(
    viewModel: DiscoveryViewModel,
    sheetState: BottomSheetState
) {

    val state = viewModel.state.collectAsStateWithLifecycle()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)

    BottomSheetScaffold(
        sheetContent = { DiscoveryFilterBottomSheet(viewModel::onIntent) },
        sheetPeekHeight = 0.dp,
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(20.dp),
        sheetElevation = 20.dp,
        sheetBackgroundColor = Color.Black,
        sheetContentColor = Color.Black
    ) {
        state.value?.let {
            DiscoveryScreen(state = state.value, onIntent = viewModel::onIntent)
        }
    }


}