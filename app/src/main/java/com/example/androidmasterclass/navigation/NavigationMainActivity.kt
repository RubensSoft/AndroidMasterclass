package com.example.androidmasterclass.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidmasterclass.R
import com.example.androidmasterclass.databinding.ActivityNavigationMainBinding

class NavigationMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation_main)
    }
}