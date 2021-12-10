package com.example.androidmasterclass.dagger

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.i("*****", "Service Provider Constructed")
    }

    fun getServiceProvider() = Log.i("*****", "Service Provider Connected")

}