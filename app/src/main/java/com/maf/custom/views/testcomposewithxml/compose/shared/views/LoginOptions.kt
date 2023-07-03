package com.maf.custom.views.testcomposewithxml.compose.shared.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R

@Composable
fun LoginOptions(
    modifier: Modifier = Modifier,
    title: String,
    buttonOneText: String,
    buttonTwoText: String,
    buttonOneIcon: Int,
    buttonTwoIcon: Int,
    headerColor: Color,
    buttonOneClick: () -> Unit = { },
    buttonTwoClick: () -> Unit = { },
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.4f)
                .height(0.8.dp)
                .background(headerColor)
        )

        Text(
            text = title,
            color = headerColor,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(
            modifier = Modifier
                .weight(0.4f)
                .height(0.8.dp)
                .background(headerColor)
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Button(
            onClick = buttonOneClick,
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .weight(0.5f)
                .padding(10.dp),
        ) {
            Image(
                painter = painterResource(id = buttonOneIcon),
                contentDescription = ""
            )
            Text(
                text = buttonOneText,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                letterSpacing = 1.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Button(
            onClick = buttonTwoClick,
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .weight(0.5f)
                .padding(10.dp),
        ) {
            Image(
                painter = painterResource(id = buttonTwoIcon),
                contentDescription = ""
            )
            Text(
                text = buttonTwoText,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                letterSpacing = 1.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginOptionsPreview() {
    LoginOptions(
        title = "Sign in options",
        buttonOneText = "Facebook",
        buttonTwoText = "Google",
        buttonOneIcon = R.drawable.facebook_logo,
        buttonTwoIcon = R.drawable.google_logo,
        headerColor = Color.White
    )
}