package com.maf.custom.views.testcomposewithxml.compose.loaction.domain

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}
