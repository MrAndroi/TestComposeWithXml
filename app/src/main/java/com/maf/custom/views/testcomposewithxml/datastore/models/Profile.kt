package com.maf.custom.views.testcomposewithxml.datastore.models

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    var name: String? = null,

    var image: String? = null,

    var phone: String? = null,

    var email: String? = null
)
