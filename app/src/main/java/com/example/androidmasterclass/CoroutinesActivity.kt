package com.example.androidmasterclass

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidmasterclass.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutinesBinding
    private lateinit var viewModel: CoroutinesViewModel

    private var count = 0
    private lateinit var textUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines)
        viewModel = ViewModelProvider(this).get(CoroutinesViewModel::class.java)
        //binding.viewModel = viewModel // to use viewModel in xml

        textUser = binding.textUser

        binding.clickHereButton.setOnClickListener {
            binding.textCount.text = count++.toString()
        }

        binding.downloadDataButton.setOnClickListener {
            lifecycleScope.launch {
                getStudents().forEach {
                    Log.d("i", "Student ${it.id}  ${it.name}")
                }
            }
        }
    }

    private suspend fun getStudents() : List<Student> {
        // simulate long task
        delay(3000)

        return listOf(
            Student(1, "Uno", "email1"),
            Student(2, "Dos", "email2"),
            Student(3, "Tres", "email3"),
            Student(4, "Cuatro", "email4")
        )
    }
}