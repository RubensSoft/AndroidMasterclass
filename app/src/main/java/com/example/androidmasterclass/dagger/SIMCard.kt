package com.example.androidmasterclass.dagger

import android.util.Log
import javax.inject.Inject

class SIMCard @Inject constructor(
    private val serviceProvider: ServiceProvider
) {
    init {
        Log.i("*****", "SIM Card Constructed")
    }

    fun getConnection() = serviceProvider.getServiceProvider()
}