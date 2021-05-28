package com.example.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

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
//            // sequentially
//            Log.d("i", "Calculation sequentially started...")
//            CoroutineScope(Dispatchers.IO).launch {
//                val result1 = task1()
//                val result2 = task2()
//                val result3 = task3()
//                val total = result1 + result2 + result3
//                Log.d("i", "Total is $total")
//            }

//            // concurrently (option 1)
//            // Launch a coroutine in a background thread belong to IO thread pool and get all concurrent executions
//            Log.d("i", "Calculation concurrently started...")
//            CoroutineScope(Dispatchers.IO).launch {
//                val result1 = async { task1() }
//                val result2 = async { task2() }
//                val result3 = async { task3() }
//                val total = result1.await() + result2.await() + result3.await()
//                Log.d("i", "Total is $total")
//            }

            // concurrently (option 2)
            // Launch a coroutine in Main thread that launch concurrent events using async(IO)
            Log.d("i", "Calculation concurrently started...")
            CoroutineScope(Dispatchers.Main).launch {
                val result1 = async(Dispatchers.IO) { task1() }
                val result2 = async(Dispatchers.IO) { task2() }
                val result3 = async(Dispatchers.IO) { task3() }
                val total = result1.await() + result2.await() + result3.await()
                Log.d("i", "Total is $total")
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

    private suspend fun task1() : Int {
        delay(10000)
        Log.d("i", "task1 returned")
        return 1
    }

    private suspend fun task2() : Int {
        delay(8000)
        Log.d("i", "task2 returned")
        return 2
    }

    private suspend fun task3() : Int {
        delay(12000)
        Log.d("i", "task3 returned")
        return 3
    }
}