package com.colman.studentlist.model

data class Student(val name: String,
                   val id: String,
                   val avatarUrl: String,
                   var isPresent: Boolean)
