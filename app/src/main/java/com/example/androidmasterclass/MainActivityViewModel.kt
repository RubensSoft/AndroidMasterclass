package com.example.androidmasterclass

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var student: Student

    init {
        student = getStudentFakeUseCase()
    }

    fun getStudent(): Student {
        return student
    }

    fun changeStudent() {
        student = Student(
            2,
            "Margarita",
            "margarita@email.com"
        )
    }

    private fun getStudentFakeUseCase(): Student {
        return Student(
            1,
            "Pepito",
            "pepito@email.com"
        )
    }
}