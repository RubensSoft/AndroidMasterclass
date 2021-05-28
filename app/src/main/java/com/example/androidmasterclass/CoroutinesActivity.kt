package com.example.androidmasterclass

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidmasterclass.databinding.ActivityCoroutinesBinding

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

        viewModel.studentDataList.observe(this, Observer { students ->
            students.forEach {
                Log.d("i", "Student ${it.id}  ${it.name}")
            }
        })

        textUser = binding.textUser

        binding.clickHereButton.setOnClickListener {
            binding.textCount.text = count++.toString()
        }

        binding.downloadDataButton.setOnClickListener {
            viewModel.getStudents()
        }
    }
}