package com.maf.custom.views.testcomposewithxml.compose.loaction.presentation.views

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.maf.custom.views.testcomposewithxml.compose.loaction.presentation.LocationViewModel

@Composable
fun MapsPicker(
    viewModel: LocationViewModel = hiltViewModel()
) {

    val currentLocation = viewModel.currentLocation
    val selectedLocation = viewModel.selectedLocation

    val properties by remember {
        mutableStateOf(MapProperties(isMyLocationEnabled = true))
    }

    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                myLocationButtonEnabled = false,
                zoomControlsEnabled = false,
                compassEnabled = false
            )
        )
    }

    val cameraPositionState = rememberCameraPositionState()
    if (!cameraPositionState.isMoving) {
        val latLng = cameraPositionState.position.target
        viewModel.updateSelectedLocation(latLng)
    }

    LaunchedEffect(currentLocation) {
        currentLocation?.let { location ->
            cameraPositionState.animate(
                CameraUpdateFactory.newCameraPosition(
                    CameraPosition(
                        LatLng(location.latitude, location.longitude),
                        20f,
                        20f,
                        20f,
                    )
                )
            )
        }
    }

    LaunchedEffect(selectedLocation) {
        selectedLocation?.let { location ->

        }
    }

    val offsetY = animateDpAsState(
        if (cameraPositionState.isMoving) (-40).dp else (-20).dp,
        animationSpec = tween(durationMillis = 200),
        label = ""
    )

    val shadow = animateDpAsState(
        if (cameraPositionState.isMoving) (0).dp else 10.dp,
        label = ""
    )

    Box(
        Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
        )
        Icon(
            imageVector = Icons.Default.LocationOn,
            tint = MaterialTheme.colors.primary,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center)
                .offset(y = offsetY.value)
                .shadow(shadow.value, CircleShape)

        )

        Icon(
            imageVector = Icons.Sharp.Home,
            tint = MaterialTheme.colors.primary,
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .size(40.dp)
                .align(Alignment.BottomEnd)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = Color.Blue, radius = 100.dp),
                    enabled = true,
                    onClickLabel = null,
                    role = Role.Tab,
                ) {
                    viewModel.getCurrentLocation()
                }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MapsPickerPreview() {
    MapsPickerPreview()
}