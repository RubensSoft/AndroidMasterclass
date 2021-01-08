package com.example.androidmasterclass

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    fun getStudent1(): Student {
        return Student(
            1,
            "Pepito",
            "pepito@bestsacret.com"
        )
    }

    fun getStudent2(): Student {
        return Student(
            2,
            "Margarita",
            "margarita@bestsacret.com"
        )
    }


}