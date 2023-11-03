package com.maf.custom.views.testcomposewithxml.compose.loaction.data.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.maf.custom.views.testcomposewithxml.compose.loaction.data.DefaultLocationTracker
import com.maf.custom.views.testcomposewithxml.compose.loaction.domain.LocationTracker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    @Provides
    @Singleton
    fun providesLocationTracker(
        fusedLocationProviderClient: FusedLocationProviderClient,
        application: Application
    ): LocationTracker = DefaultLocationTracker(
        fusedLocationProviderClient = fusedLocationProviderClient,
        application = application
    )
}