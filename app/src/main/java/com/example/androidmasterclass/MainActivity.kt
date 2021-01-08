package com.example.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.androidmasterclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submitButton.setOnClickListener {
            displayGreeting()
        }

        binding.startButton.setOnClickListener {
            startOrStopProgressBar()
        }

        binding.student = getStudent()
//        val student = getStudent()
//        binding.name.text = student.name
//        binding.email.text = student.email
    }

    private fun displayGreeting() {
        binding.apply {
            greetingTextView.text = "Hello! " + nameEditText.text
        }
    }

    private fun startOrStopProgressBar() {
        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                startButton.text = "STOP"
            } else {
                progressBar.visibility = View.GONE
                startButton.text = "START"
            }
        }
    }

    private fun getStudent(): Student {
        return Student(
            1,
            "Pepito",
            "pepito@bestsacret.com"
        )
    }
}