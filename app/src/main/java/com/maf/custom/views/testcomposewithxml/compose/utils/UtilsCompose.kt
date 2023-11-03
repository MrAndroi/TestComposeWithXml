package com.maf.custom.views.testcomposewithxml.compose.utils

import android.content.Context
import android.content.Intent
import android.content.res.Resources.getSystem
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat


/**
 * @param visible if false content is invisible ie. space is still occupied
 */
@Composable
fun Visibility(
    visible: Boolean,
    visibilityType: VisibilityType = VisibilityType.INVISIBLE,
    content: @Composable () -> Unit
) {
    val contentSize = remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = Modifier
        .onSizeChanged { size -> contentSize.value = size }) {
        if (visible) {
            content()
        } else {
            when(visibilityType) {
                VisibilityType.INVISIBLE -> {
                    Spacer(modifier = Modifier.size(contentSize.value.width.pxToDp(), contentSize.value.height.pxToDp()))
                }
                VisibilityType.GONE -> {
                    Spacer(modifier = Modifier.size(0.dp, 0.dp))
                }
            }

        }
    }
}


fun Int.pxToDp(): Dp {
    return (this / getSystem().displayMetrics.density).dp
}

fun Context.openAppSettings() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    ContextCompat.startActivity(this, intent, null)
}

enum class VisibilityType {
    INVISIBLE,
    GONE
}