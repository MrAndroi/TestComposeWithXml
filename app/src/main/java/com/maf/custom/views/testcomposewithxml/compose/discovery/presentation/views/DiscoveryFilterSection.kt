package com.maf.custom.views.testcomposewithxml.compose.discovery.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun DiscoveryFilterSection(
    onIntent: (DiscoveryIntent) -> Unit = {},
) {
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Sort By: ")
                }
                withStyle(style = SpanStyle(color = Color(0xFFFE724C))) {
                    append("Popular ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF9796A1))) {
                    append("v")
                }
            }
            Text(
                text = annotatedText,
                fontSize = 14.sp,
                lineHeight = 50.sp,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                modifier = Modifier.clickable { }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        onIntent(DiscoveryIntent.OnFilterClick)
                    }
                    .padding(end = 20.dp),
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DiscoveryFilterSectionPreview() {
    DiscoveryFilterSection()
}