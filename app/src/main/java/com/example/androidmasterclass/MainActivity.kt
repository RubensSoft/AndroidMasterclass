package com.example.androidmasterclass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.androidmasterclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainActivityViewModel()

        binding.viewModel = viewModel

        binding.submitButton.setOnClickListener {
            viewModel.changeStudent()
        }

        viewModel.studentData.observe(this, Observer {
            binding.viewModel = viewModel
        })
    }
}