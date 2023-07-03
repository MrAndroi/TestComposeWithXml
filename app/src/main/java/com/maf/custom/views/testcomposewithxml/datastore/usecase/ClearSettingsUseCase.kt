package com.maf.custom.views.testcomposewithxml.datastore.usecase

import androidx.datastore.core.DataStore
import com.maf.custom.views.testcomposewithxml.datastore.models.Settings
import javax.inject.Inject

class ClearSettingsUseCase @Inject constructor(private val settings: DataStore<Settings>) {

    suspend operator fun invoke(): Settings {
        return settings.updateData { userSettings ->
            val userProfile = userSettings.userProfile.copy(
                name = null,
                image = null,
                phone = null,
                email = null,
            )
            userSettings.copy(
                accessToken = null,
                refreshToken = null,
                loggedInUser = null,
                userProfile = userProfile,
                deviceId = null
            )
        }
    }
}