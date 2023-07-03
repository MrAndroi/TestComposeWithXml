package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent

@Composable
fun DiscoveryFilterBottomSheet(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        LazyColumn {
            items(10) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .clickable(
                            indication = rememberRipple(
                                color = Color.Red
                            ),
                            interactionSource = MutableInteractionSource()
                        ) {
                            onIntent(
                                DiscoveryIntent.OnFilterItemClick(
                                    "Type $index"
                                )
                            )
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Type $index",
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp)
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