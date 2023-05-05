package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R

@Composable
fun CartTotalSection(
    totalItems: Int,
    totalPrice: Float
) {
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    text = "Total",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Thin)),
                    style = TextStyle(
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "($totalItems Items)",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Thin)),
                    style = TextStyle(
                        color = Color(0xFFBEBEBE)
                    )
                )
            }
            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("$$totalPrice")
                }
                withStyle(style = SpanStyle(color = Color(0xFF9796A1), fontSize = 14.sp)) {
                    append("  USD")
                }
            }
            Text(
                text = annotatedText,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.ExtraBold)),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CartTotalSectionPreview() {
    CartTotalSection(
        2,
        25.0f
    )
}