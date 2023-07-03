package com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.model.WelcomeIntent

@Composable
fun WelcomeScreen(
    onIntent: (WelcomeIntent) -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.welcome_screen_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.welcome_screen_shadow),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        val annotatedText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("Welcome To ")
            }
            withStyle(style = SpanStyle(color = Color(0xFFFE724C))) {
                append("\n\n\nFoodHub")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(color = 0xB330384F),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                )
            ) {
                append("\n\nYour favourite foods delivered fast at your door.")
            }
        }
        Text(
            text = annotatedText,
            fontSize = 45.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.ExtraBold)),
            style = Typography().h2,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 375.dp, end = 40.dp, start = 30.dp)
        )
        WelcomeBottomSection(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onSignUpClick = {
                onIntent(WelcomeIntent.OnSignUpClick)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}