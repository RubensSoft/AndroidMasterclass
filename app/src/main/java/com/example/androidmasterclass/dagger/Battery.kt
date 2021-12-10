package com.example.androidmasterclass.dagger

import android.util.Log

class Battery {
    init {
        Log.i("*****", "Battery constructed")
    }

    fun getPower() = Log.i("*****", "Battery power is available")
}