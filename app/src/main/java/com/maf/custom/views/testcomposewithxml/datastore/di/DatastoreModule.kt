package com.maf.custom.views.testcomposewithxml.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.maf.custom.views.testcomposewithxml.datastore.models.Settings
import com.maf.custom.views.testcomposewithxml.datastore.serializers.SettingsSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    private const val SETTINGS_STORE_FILE_NAME = "settings_file.pb"

    @Provides
    @Singleton
    fun provideSettingsDataStore(@ApplicationContext context: Context): DataStore<Settings> {
        return DataStoreFactory.create(
            serializer = SettingsSerializer(),
            produceFile = { context.dataStoreFile(SETTINGS_STORE_FILE_NAME) },
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
    }

}