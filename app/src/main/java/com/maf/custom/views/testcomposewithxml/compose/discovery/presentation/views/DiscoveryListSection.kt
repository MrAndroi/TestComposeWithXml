package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiscoveryList(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    val listState = rememberLazyListState()
    val scrollState by remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }

    Surface(modifier = Modifier.padding(bottom = 70.dp),) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                state = listState
            ) {
                stickyHeader {
                    Column {
                        DiscoveryHeader(onIntent, scrollState)
                        DiscoveryFilterSection(onIntent)
                    }
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