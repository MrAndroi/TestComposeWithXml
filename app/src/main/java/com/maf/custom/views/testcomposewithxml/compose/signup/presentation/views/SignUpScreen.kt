package com.maf.custom.views.testcomposewithxml.compose.signup.presentation.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
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
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.shared.views.InputField
import com.maf.custom.views.testcomposewithxml.compose.shared.views.LoginOptions
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpErrorState
import com.maf.custom.views.testcomposewithxml.compose.signup.presentation.model.SignUpIntent
import kotlinx.coroutines.delay


const val SIGN_UP_BUTTON_ANIM_DURATION = 200
const val RIGHT_CORNER_IMAGE_ANIM_DURATION = 1000
const val RIGHT_CORNER_IMAGE_ANIM_DELAY = 3000

@Composable
fun SignUpScreen(
    onIntent: (SignUpIntent) -> Unit = { },
    signUpErrorState: SignUpErrorState = SignUpErrorState.None
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isClicked by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var isSuccessAnim by remember { mutableStateOf(false) }
    var showWhiteProgressBar by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isClicked) 0.95f else 1.0f,
        animationSpec = tween(SIGN_UP_BUTTON_ANIM_DURATION),
        label = "button_scale"
    )

    val scaleForRightCorner by animateFloatAsState(
        targetValue = if (isSuccessAnim) 50f else 1.0f,
        animationSpec = tween(RIGHT_CORNER_IMAGE_ANIM_DURATION),
        label = "left_image_scale"
    )

    LaunchedEffect(isClicked) {
        if (isClicked) {
            delay(SIGN_UP_BUTTON_ANIM_DURATION.toLong())
            isClicked = false
            onIntent(
                SignUpIntent.OnSignUpClick(
                    fullName = fullName,
                    email = email,
                    password = password
                )
            )
            if (signUpErrorState is SignUpErrorState.None) {
                isSuccess = true
            }
        }
    }

    LaunchedEffect(isSuccess) {
        if (isSuccess) {
            isSuccessAnim = true
            showWhiteProgressBar = true
            delay(RIGHT_CORNER_IMAGE_ANIM_DELAY.toLong())
            onIntent(SignUpIntent.SignInUser)
        }
    }

    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.top_corner_start_image),
                contentDescription = "",
                modifier = Modifier.align(Alignment.TopStart)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_bold)),
                    fontSize = 26.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                )

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    hint = "Full Name",
                    errorText = "Full Name should contain only letters and spaces.",
                    showError = signUpErrorState is SignUpErrorState.FullName,
                    onTextChanged = {
                        fullName = it
                    }
                )

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    hint = "Email",
                    errorText = "Wrong Email",
                    showError = signUpErrorState is SignUpErrorState.Email,
                    onTextChanged = {
                        email = it
                    }
                )

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    hint = "Password",
                    errorText = "Password should be at least 8 characters long and contain at least one letter and one digit",
                    isPassword = true,
                    showError = signUpErrorState is SignUpErrorState.Password,
                    onTextChanged = {
                        password = it
                    }
                )

                Button(
                    modifier = Modifier
                        .scale(scale),
                    onClick = {
                        isClicked = true
                        isSuccessAnim = true
                    },
                    shape = RoundedCornerShape(100.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold)),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 73.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 25.dp)
            ) {
                val annotatedText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Already have an account?  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(
                                Font(
                                    R.font.sofia_pro_bold,
                                    FontWeight.ExtraBold
                                )
                            )
                        )
                    ) {
                        append("Login")
                    }
                }
                Text(
                    text = annotatedText,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.ExtraBold)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                )
                LoginOptions(
                    title = "Sign Up With",
                    buttonOneText = "FACEBOOK",
                    buttonTwoText = "GOOGLE",
                    buttonOneIcon = R.drawable.facebook_logo,
                    buttonTwoIcon = R.drawable.google_logo,
                    headerColor = Color(0xFF5B5B5E),
                    modifier = Modifier
                        .padding(top = 30.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.top_corner_end_image),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .scale(scaleForRightCorner)
            )

            AnimatedVisibility(
                modifier = Modifier.fillMaxSize(),
                visible = showWhiteProgressBar
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center),
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewSignUpScreen() {
    MdcTheme {
        SignUpScreen()
    }
}