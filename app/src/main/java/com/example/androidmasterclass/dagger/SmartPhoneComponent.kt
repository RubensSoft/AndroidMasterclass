package com.example.androidmasterclass.dagger

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun provideSmartPhone(): SmartPhone
}