package com.example.androidmasterclass.dagger

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {

    fun provideSmartPhone(): SmartPhone
}