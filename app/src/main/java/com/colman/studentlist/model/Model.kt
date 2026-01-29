package com.colman.studentlist.model

import kotlin.collections.mutableListOf

class Model private constructor() {
    val students = mutableListOf<Student>()

    init {
        for (i in 1..10) {
            val student = Student(
                name = "Student $i",
                id = "ID${1000 + i}",
                avatarUrl = "https://i.pravatar.cc/150?img=$i",
                isPresent = false
            )
            students.add(student)
        }
    }

    companion object {
        val shared = Model()
    }

    fun getStudentByIndex(index: Int): Student {
        return this.students[index]
    }
}