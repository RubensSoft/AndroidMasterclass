package com.example.androidmasterclass.dagger

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor(){
    init {
        Log.i("*****", "Battery constructed")
    }

    fun getPower() = Log.i("*****", "Battery power is available")
}