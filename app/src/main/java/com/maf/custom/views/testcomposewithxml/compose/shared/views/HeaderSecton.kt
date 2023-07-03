package com.maf.custom.views.testcomposewithxml.compose.shared.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.utils.Visibility
import com.maf.custom.views.testcomposewithxml.compose.utils.VisibilityType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HeaderSection(
    showBack: Boolean = true,
    showTitle: Boolean = true,
    showCartImage: Boolean = false,
    title: String = "",
    onBackClick: () -> Unit = { },
) {
    Surface(
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Visibility(visible = showBack) {
                Card(
                    modifier = Modifier.size(38.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp),
                    onClick = { onBackClick() },
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_back_black),
                            contentDescription = "Back",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            Visibility(visible = showTitle) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.SemiBold)),
                    color = Color(0xFF111719),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HeaderSectionPreview() {
    HeaderSection(
        showBack = true,
        showTitle = true,
        showCartImage = false,
        title = "Cart"
    )
}