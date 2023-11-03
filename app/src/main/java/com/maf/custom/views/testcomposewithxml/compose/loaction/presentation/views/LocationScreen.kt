package com.maf.custom.views.testcomposewithxml.compose.loaction.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.maf.custom.views.testcomposewithxml.compose.utils.openAppSettings

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationScreen() {

    fun getButtonText(shouldShowRationale: Boolean): String {
        return if (shouldShowRationale) {
            "Open Settings"
        } else {
            "Request permissions"
        }
    }

    fun getRationalText(shouldShowRationale: Boolean): String {
        return if (shouldShowRationale) {
            "Getting your exact location is important for this app. " +
                    "Please grant us fine location. Thank you :D"
        } else {
            "This feature requires location permission, please enable it."
        }
    }

    Surface(
        modifier = Modifier.padding(bottom = 50.dp)
    ) {

        val context = LocalContext.current

        val locationPermissionsState = rememberMultiplePermissionsState(
            listOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
            )
        )

        if (locationPermissionsState.allPermissionsGranted) {
            MapsPicker()
        } else {

            LaunchedEffect(Unit) {
                locationPermissionsState.launchMultiplePermissionRequest()
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = getRationalText(locationPermissionsState.shouldShowRationale),
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        if (locationPermissionsState.shouldShowRationale) {
                            context.openAppSettings()
                        } else {
                            locationPermissionsState.launchMultiplePermissionRequest()
                        }
                    })
                {
                    Text(getButtonText(locationPermissionsState.shouldShowRationale))
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    LocationScreen()
}