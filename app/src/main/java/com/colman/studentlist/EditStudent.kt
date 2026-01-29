package com.colman.studentlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentlist.model.Model

class EditStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentIndex = intent.getIntExtra("student_index", 0)
        val student = Model.shared.students[studentIndex]

        val nameEditText = findViewById<EditText>(R.id.editStudentName)
        val idEditText = findViewById<EditText>(R.id.editStudentId)
        val checkBox = findViewById<CheckBox>(R.id.editStudentCheckBox)
        val saveBtn = findViewById<Button>(R.id.editStudentSaveBtn)
        val deleteBtn = findViewById<Button>(R.id.editStudentDeleteBtn)
        val cancelBtn = findViewById<Button>(R.id.editStudentCancelBtn)

        nameEditText.setText(student.name)
        idEditText.setText(student.id)
        checkBox.isChecked = student.isPresent

        saveBtn.setOnClickListener {
            student.name = nameEditText.text.toString()
            student.id = idEditText.text.toString()
            student.isPresent = checkBox.isChecked
            finish()
        }

        deleteBtn.setOnClickListener {
            if (studentIndex >= 0 && studentIndex < Model.shared.students.size) {
                Model.shared.students.removeAt(studentIndex)
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        cancelBtn.setOnClickListener {
            finish()
        }
    }
}