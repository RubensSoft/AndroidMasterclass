package com.example.androidmasterclass.dagger

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(
    private val battery: Battery,
    private val memoryCard: MemoryCard,
    private val simCard: SIMCard
){
    init {
        battery.getPower()
        memoryCard.getSpaceAvailability()
        simCard.getConnection()
    }

    fun makeACall() = Log.i("*****", "Calling...")
}