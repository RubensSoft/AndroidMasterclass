package com.example.androidmasterclass.dagger

import android.util.Log

class ServiceProvider {
    init {
        Log.i("*****", "Service Provider Constructed")
    }

    fun getServiceProvider() = Log.i("*****", "Service Provider Connected")

}