package com.example.androidmasterclass.dagger

import dagger.Component

@Component(modules = [SmartPhoneModule::class])
interface SmartPhoneComponent {

    fun provideSmartPhone(): SmartPhone
}