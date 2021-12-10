package com.example.androidmasterclass.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmasterclass.R

class DaggerDemoActivity : AppCompatActivity() {
    private lateinit var smartphone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_demo)

        smartphone = DaggerSmartPhoneComponent.create().provideSmartPhone()
        smartphone.makeACall()
    }
}