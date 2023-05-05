package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent
import com.maf.custom.views.testcomposewithxml.compose.shared.views.HeaderSection

@Composable
fun DiscoveryHeader(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(start = 27.dp)) {
                Spacer(modifier = Modifier.height(80.dp))
                val annotatedText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Fast ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFFFE724C))) {
                        append("\nFood")
                    }
                }
                Text(
                    text = annotatedText,
                    fontSize = 45.sp,
                    lineHeight = 50.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.ExtraBold)),
                    style = Typography().h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "80 type of pizza",
                    fontSize = 19.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                    color = Color(0xFF9796A1)
                )

            }
            Image(
                painter = painterResource(id = R.drawable.corner_pizza),
                contentDescription = "",
                modifier = Modifier
                    .size(width = 350.dp, height = 220.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        HeaderSection(
            showCartImage = true,
            onBackClick = {
                onIntent(DiscoveryIntent.OnBackClick)
            },
            onCartClick = {
                onIntent(DiscoveryIntent.OnCartClick)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DiscoveryHeaderPreview() {
    DiscoveryHeader()
}