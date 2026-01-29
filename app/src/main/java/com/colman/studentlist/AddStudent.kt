package com.colman.studentlist

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentlist.model.Model
import com.colman.studentlist.model.Student

class AddStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val nameEditText = findViewById<EditText>(R.id.addStudentName)
        val idEditText = findViewById<EditText>(R.id.addStudentId)
        val checkBox = findViewById<CheckBox>(R.id.addStudentCheckBox)
        val saveBtn = findViewById<Button>(R.id.addStudentSaveBtn)
        val cancelBtn = findViewById<Button>(R.id.addStudentCancelBtn)

        saveBtn.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val isChecked = checkBox.isChecked

            val student = Student(name, id, "", isChecked)
            Model.shared.students.add(student)
            finish()
        }

        cancelBtn.setOnClickListener {
            finish()
        }
    }
}