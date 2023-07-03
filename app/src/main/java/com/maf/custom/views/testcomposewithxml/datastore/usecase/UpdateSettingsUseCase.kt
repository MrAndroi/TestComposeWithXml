package com.maf.custom.views.testcomposewithxml.datastore.usecase

import androidx.datastore.core.DataStore
import com.maf.custom.views.testcomposewithxml.datastore.models.Settings
import javax.inject.Inject

class UpdateSettingsUseCase @Inject constructor(private val settings: DataStore<Settings>) {

    suspend operator fun invoke(
        accessToken: String? = null,
        refreshToken: String? = null,
        isLoggedIn: Boolean? = null,
        userName: String? = null,
        userImage: String? = null,
        userPhone: String? = null,
        userEmail: String? = null,
        deviceId: String? = null,
    ) {
        settings.updateData { userSettings ->
            val userProfile = userSettings.userProfile.copy(
                name = userName ?: userSettings.userProfile.name,
                image = userImage ?: userSettings.userProfile.image,
                phone = userPhone ?: userSettings.userProfile.phone,
                email = userEmail ?: userSettings.userProfile.email,
            )
            userSettings.copy(
                accessToken = accessToken ?: userSettings.accessToken,
                refreshToken = refreshToken ?: userSettings.refreshToken,
                loggedInUser = isLoggedIn ?: userSettings.loggedInUser,
                userProfile = userProfile,
                deviceId = deviceId
            )
        }
    }
}