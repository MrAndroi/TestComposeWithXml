package com.maf.custom.views.testcomposewithxml.datastore.models

import kotlinx.serialization.Serializable

@Serializable
data class Settings(
    var accessToken: String? = null,

    var refreshToken: String? = null,

    var loggedInUser: Boolean? = null,

    var userProfile: Profile = Profile(),

    var deviceId: String? = null,
)
