package com.maf.custom.views.testcomposewithxml.compose.cart.data.di

import com.maf.custom.views.testcomposewithxml.compose.cart.data.CartRepositoryImpl
import com.maf.custom.views.testcomposewithxml.compose.cart.domain.CartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CartModuleLocale {

    @Binds
    fun bindCartRepository(cartRepositoryImpl: CartRepositoryImpl): CartRepository
}