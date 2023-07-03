package com.maf.custom.views.testcomposewithxml.compose.profile.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.profile.presentation.model.ProfileIntent
import com.maf.custom.views.testcomposewithxml.compose.shared.views.InputField

@Composable
fun ProfileScreen(
    onIntent: (ProfileIntent) -> Unit = { }
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.top_center_image),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.more_icon),
                contentDescription = "",
                modifier = Modifier
                    .clickable { onIntent(ProfileIntent.OnMoreClick) }
                    .wrapContentSize()
                    .align(Alignment.TopStart),
                contentScale = ContentScale.FillWidth,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Text(
                    text = "Eljad Eendaz",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_bold)),
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Eljad Eendaz",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                    color = Color(0xFF9796A1),
                    textAlign = TextAlign.Center
                )

                InputField(
                    hint = "Full Name",
                    errorText = "Invalid Full Name",
                    modifier = Modifier.padding(top = 50.dp, start = 20.dp, end = 20.dp)
                )
                InputField(
                    hint = "E-mail",
                    errorText = "Invalid Email",
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)
                )
                InputField(
                    hint = "Phone Number",
                    errorText = "Invalid Phone Number",
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)
                )
            }
        }

    }
}

@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .size(108.dp)
            .background(
                shape = RoundedCornerShape(100.dp),
                color = Color.White
            )
            .shadow(
                elevation = 50.dp,
                spotColor = Color(0xFFFFC529),
                clip = true,
                shape = RoundedCornerShape(50.dp)
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "",
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(100.dp))
        )
        Image(
            painter = painterResource(id = R.drawable.camera_icon),
            contentDescription = "",
            modifier = Modifier
                .padding(13.dp)
                .background(color = Color.White, shape = RoundedCornerShape(100.dp))
                .size(27.dp)
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}