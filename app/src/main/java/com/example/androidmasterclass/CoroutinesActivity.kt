package com.example.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var textUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        val clickHereButton = findViewById<Button>(R.id.clickHereButton)
        val textCount = findViewById<TextView>(R.id.textCount)
        val downloadDataButton = findViewById<Button>(R.id.downloadDataButton)
        textUser = findViewById(R.id.textUser);

        clickHereButton.setOnClickListener {
            textCount.text = count++.toString()
        }

        downloadDataButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }
    }

    // simulate long task
    private suspend fun downloadData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                textUser.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }

}