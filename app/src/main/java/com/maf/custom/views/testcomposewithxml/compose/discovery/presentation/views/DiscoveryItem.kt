package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.model.DiscoveryIntent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DiscoveryItem(
    onIntent: (DiscoveryIntent) -> Unit = {}
) {
    Surface {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            onClick = {
                onIntent(
                    DiscoveryIntent.OnFoodItemClick(
                        0,
                        "Chicken Hawaiian"
                    )
                )
            }
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.pasta_image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(165.dp)
                            .clip(RoundedCornerShape(15.dp))
                    )

                    Text(
                        text = "Chicken Hawaiian",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.SemiBold)),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 13.dp, top = 20.dp)
                    )
                    Text(
                        text = "Chicken, Cheese and pineapple",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                        color = Color(0xFF5B5B5E),
                        modifier = Modifier.padding(start = 13.dp, top = 5.dp, bottom = 13.dp)
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.ic_love),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(12.dp),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    val annotatedText = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFFE724C))) {
                            append("$")
                        }
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("10.35")
                        }
                    }
                    Text(
                        text = annotatedText,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Bold)),
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 12.dp)
                            .wrapContentSize()
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoveryItemPreview() {
    DiscoveryItem()
}