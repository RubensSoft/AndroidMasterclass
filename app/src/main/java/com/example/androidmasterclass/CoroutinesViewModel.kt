package com.example.androidmasterclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesViewModel : ViewModel() {
    private var studentRepository = StudentRepository()

    private var studentList = MutableLiveData<List<Student>>()
    val studentDataList: LiveData<List<Student>>
        get() = studentList

    fun getStudents() {
        viewModelScope.launch {
            var result : List<Student> = emptyList()
            withContext(Dispatchers.IO) {
                result = studentRepository.getStudents()
            }
            studentList.value = result
        }
    }
}

class StudentRepository {
    suspend fun getStudents() : List<Student> {
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

