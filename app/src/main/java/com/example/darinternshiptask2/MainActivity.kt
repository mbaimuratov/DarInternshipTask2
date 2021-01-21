package com.example.darinternshiptask2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var studentList: ArrayList<Student>
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var studentNumberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            studentList = savedInstanceState.getParcelableArrayList("list_of_students")!!
        } else {
            studentList = ArrayList()
        }

        nameEditText = findViewById(R.id.et_name)
        surnameEditText = findViewById(R.id.et_surname)

        studentNumberTextView = findViewById(R.id.tv_student_count)

        studentNumberTextView.text = studentList.size.toString()

        findViewById<Button>(R.id.action_add_student).setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()

            if (name == "" || surname == "") {
                Snackbar.make(it, "Both name and surname must be filled", Snackbar.LENGTH_SHORT).show()
            }
            else {
                studentList.add(Student(name, surname))

                refreshLayout()

                Snackbar.make(it, "Student added", Snackbar.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.action_to_list_of_students).setOnClickListener {
            val intent = Intent(this, StudentListActivity::class.java)

            intent.putParcelableArrayListExtra("list_of_students", studentList)

            startActivity(intent)
        }
    }

    private fun refreshLayout() {
        studentNumberTextView.text = studentList.size.toString()
        nameEditText.text.clear()
        surnameEditText.text.clear()
        this.currentFocus?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("list_of_students", studentList)
    }
}