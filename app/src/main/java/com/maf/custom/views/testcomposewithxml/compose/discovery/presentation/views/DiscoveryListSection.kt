package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.DiscoveryViewModel
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.shared.model.DataStateModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiscoveryList(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                stickyHeader {
                    DiscoveryHeader(onIntent)
                }
                stickyHeader {
                    DiscoveryFilterSection(onIntent)
                }
                items(10) {
                    DiscoveryItem(onIntent)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListPreview() {
    DiscoveryList()
}