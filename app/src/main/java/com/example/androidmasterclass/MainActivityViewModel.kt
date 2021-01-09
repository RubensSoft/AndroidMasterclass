package com.example.androidmasterclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var student = MutableLiveData<Student>()
    val studentData: LiveData<Student>
    get() = student

    init {
        student.value = getStudentFakeUseCase()
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