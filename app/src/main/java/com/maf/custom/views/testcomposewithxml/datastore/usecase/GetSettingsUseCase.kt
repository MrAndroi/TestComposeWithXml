package com.maf.custom.views.testcomposewithxml.datastore.usecase

import androidx.datastore.core.DataStore
import com.maf.custom.views.testcomposewithxml.datastore.models.Settings
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(private val settings: DataStore<Settings>) {

    suspend operator fun invoke(): Settings {
        return settings.data.first()
    }
}