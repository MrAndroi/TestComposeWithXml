package com.maf.custom.views.testcomposewithxml.compose.splash.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.R

@Composable
fun SplashScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.food_hub_logo),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MdcTheme {
        SplashScreen()
    }
}