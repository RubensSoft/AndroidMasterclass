package com.example.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        val clickHereButton = findViewById<Button>(R.id.clickHereButton)
        val textView = findViewById<TextView>(R.id.textView)
        val downloadDataButton = findViewById<Button>(R.id.downloadDataButton)

        clickHereButton.setOnClickListener {
            textView.text = count++.toString()
        }

        downloadDataButton.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                downloadData()
//            }

            CoroutineScope(Dispatchers.IO).launch {
                Log.i("i", "Hello from ${Thread.currentThread().name}")
            }

            CoroutineScope(Dispatchers.Main).launch {
                Log.i("i", "Hello from ${Thread.currentThread().name}")
            }
        }
    }

    // simulate long task
    private fun downloadData() {
        for (i in 1..200000) {
            Log.i("i","Download data $i in ${Thread.currentThread().name}")
        }
    }
}