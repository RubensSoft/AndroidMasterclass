package com.example.androidmasterclass.dagger

import dagger.Module
import dagger.Provides

@Module
class SmartPhoneModule {

    @Provides
    fun provideMemoryCard(): MemoryCard {
        return MemoryCard()
    }

    @Provides
    fun provideBattery(): Battery {
        return Battery()
    }

    @Provides
    fun provideSIMCard(): SIMCard {
        return SIMCard(ServiceProvider())
    }
}