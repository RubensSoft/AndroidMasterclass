package com.example.androidmasterclass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var student = MutableLiveData<Student>()

    init {
        student.value = getStudentFakeUseCase()
    }

    fun getMutableLiveDataStudent(): MutableLiveData<Student> {
        return student
    }

    fun getStudent(): Student? {
        return student.value
    }

    fun changeStudent() {
        when (student.value?.id) {
            1 -> student.value = Student(
                2,
                "Margarita",
                "margarita@email.com"
            )
            2 -> student.value = Student(
                1,
                "Pepito",
                "pepito@email.com"
            )
        }
    }

    private fun getStudentFakeUseCase(): Student {
        return Student(
            1,
            "Pepito",
            "pepito@email.com"
        )
    }
}