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

            CoroutineScope(Dispatchers.Main).launch {
//                textUser.text = UserDataManagerWithoutGuarantee().getTotalUserCount().toString()
                textUser.text = UserDataManagerWithGuarantee().getTotalUserCount().toString()
            }
        }
    }

//    // simulate long task
//    private suspend fun downloadData() {
//        for (i in 1..200000) {
//            withContext(Dispatchers.Main) {
//                textUser.text = "Downloading user $i in ${Thread.currentThread().name}"
//            }
//        }
//    }
}

class UserDataManagerWithoutGuarantee {
    suspend fun getTotalUserCount() : Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }

        return count + deferred.await()
    }
}

class UserDataManagerWithGuarantee {
    suspend fun getTotalUserCount() : Int {
        var count = 0
        lateinit var deferred : Deferred<Int>
        lateinit var deferredOneMore : Deferred<Int>

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }

            deferredOneMore = async(Dispatchers.IO) {
                getOne()
            }
        }

        return count + deferred.await() + deferredOneMore.await()
    }

    private suspend fun getOne() : Int {
        delay(1000)
        return 1
    }
}