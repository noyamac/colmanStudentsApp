package com.colman.studentlist

import OnItemClickListener
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.colman.studentlist.model.Model
import com.colman.studentlist.model.Student
import com.google.android.material.appbar.MaterialToolbar
import studentAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val studentsRecyclerView = findViewById<RecyclerView>(R.id.studentlist)
        studentsRecyclerView.setHasFixedSize(true)
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = studentAdapter(Model.shared.students).apply {
            listener = object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    Intent(this@MainActivity, StudentDetails::class.java).also {
                        it.putExtra("student_index", position)
                    }
                }

                override fun onStudentClick(student: Student?, position: Int) {
                    Intent(this@MainActivity, StudentDetails::class.java).apply {
                        putExtra("student_name", student?.name)
                        putExtra("student_id", student?.id)
                        putExtra("student_present", student?.isPresent)
                        putExtra("student_index", position)

                        startActivity(this)
                    }
                }
            }
        }

        studentsRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        (findViewById<RecyclerView>(R.id.studentlist).adapter as studentAdapter).notifyDataSetChanged()
    }
}