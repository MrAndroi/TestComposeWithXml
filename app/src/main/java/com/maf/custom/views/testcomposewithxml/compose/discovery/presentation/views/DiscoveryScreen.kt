package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryStateModel

@Composable
fun DiscoveryScreen(
    state: DiscoveryStateModel?,
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            is DiscoveryStateModel.Error -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = state.message,
                        fontSize = 45.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.Bold)),
                    )
                }
            }

            DiscoveryStateModel.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            is DiscoveryStateModel.Success -> {
                Column {
                    DiscoveryList(onIntent)
                }
            }

            else -> {}
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun MainDiscoveryScreenPreview() {
    DiscoveryScreen(
        state = DiscoveryStateModel.Success("")
    )
}