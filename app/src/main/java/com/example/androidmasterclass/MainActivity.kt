package com.example.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        viewModel.getMutableLiveDataStudent().observe(this, Observer {
            binding.viewModel = viewModel
        })
    }
}