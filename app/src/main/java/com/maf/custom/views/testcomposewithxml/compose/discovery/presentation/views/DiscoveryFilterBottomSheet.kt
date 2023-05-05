package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent

@Composable
fun DiscoveryFilterBottomSheet(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {

        LazyColumn {
            items(10) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clickable { onIntent(DiscoveryIntent.OnFilterItemClick("Type $index")) },
                ) {
                    Text(
                        text = "Type $index",
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .align(Alignment.Center)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                            .background(Color(0xFFF1F2F3))
                    )
                }
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun DiscoveryFilterBottomSheetPreview() {
    DiscoveryFilterBottomSheet()
}