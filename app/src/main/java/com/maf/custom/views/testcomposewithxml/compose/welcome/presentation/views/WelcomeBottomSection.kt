package com.maf.custom.views.testcomposewithxml.compose.welcome.presentation.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.shared.views.LoginOptions

@Composable
fun WelcomeBottomSection(
    modifier: Modifier,
    onSignUpClick: () -> Unit = { }
) {
    Column(modifier = modifier.wrapContentSize()) {
        LoginOptions(
            title = "Sign In Options",
            buttonOneText = "Facebook",
            buttonTwoText = "Google",
            buttonOneIcon = R.drawable.facebook_logo,
            buttonTwoIcon = R.drawable.google_logo,
            headerColor = Color.White,
            buttonOneClick = {},
            buttonTwoClick = {}
        )
        Button(
            onClick = onSignUpClick,
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x33FFFFFF)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 23.dp),
            border = BorderStroke(1.dp, Color.White)
        ) {
            Text(
                text = "Start with email or phone",
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                letterSpacing = 1.sp,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 15.dp),
                color = Color.White,
            )
        }
        val annotatedText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White)) {
                append("Already have an account?  ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.ExtraBold))
                )
            ) {
                append("Sign In")
            }
        }
        Text(
            text = annotatedText,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.ExtraBold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeBottomSectionPreview() {
    WelcomeBottomSection(Modifier.wrapContentSize())
}