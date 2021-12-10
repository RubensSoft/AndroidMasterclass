package com.example.androidmasterclass.dagger

import android.util.Log

class MemoryCard {
    init {
        Log.i("*****", "Memory Card Constructed")
    }

    fun getSpaceAvailability() = Log.i("*****", "Memory space available")
}