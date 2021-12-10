package com.example.androidmasterclass.dagger

import android.util.Log
import javax.inject.Inject

class MemoryCard @Inject constructor() {
    init {
        Log.i("*****", "Memory Card Constructed")
    }

    fun getSpaceAvailability() = Log.i("*****", "Memory space available")
}