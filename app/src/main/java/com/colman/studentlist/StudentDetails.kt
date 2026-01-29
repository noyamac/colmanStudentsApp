package com.colman.studentlist

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentlist.model.Model
import com.colman.studentlist.model.Student
import com.google.android.material.appbar.MaterialToolbar

class StudentDetails : AppCompatActivity() {
    private var student: Student? = null
    private var studentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentIndex = intent.getIntExtra("student_index", 0)
        student = Model.shared.getStudentByIndex(studentIndex)

        val textViewName = findViewById<TextView>(R.id.textViewStudentName)
        val textViewId = findViewById<TextView>(R.id.textViewStudentId)
        val checkBoxChecked = findViewById<CheckBox>(R.id.checkBoxStudentPresent)
        val imageViewDetail = findViewById<ImageView>(R.id.studentImage)

        textViewName.text = student?.name
        textViewId.text = student?.id
        checkBoxChecked.isChecked = student?.isPresent ?: false
        imageViewDetail.setImageResource(R.drawable.avatar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}