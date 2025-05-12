package com.example.m3tecnologies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubmitActivity : AppCompatActivity() {

    lateinit var submitButton: Button
    lateinit var backButton: Button
    lateinit var studentIdTextView: TextView
    lateinit var schoolNameTextView: TextView
    lateinit var classTextView: TextView
    lateinit var subjectTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        submitButton = findViewById(R.id.submitButton)
        backButton = findViewById(R.id.backButton)
        studentIdTextView = findViewById(R.id.studentIdTextView)
        schoolNameTextView = findViewById(R.id.schoolNameTextView)
        classTextView = findViewById(R.id.classTextView)
        subjectTextView = findViewById(R.id.subjectTextView)

        val studentId = intent.getStringExtra("studentId")
        val schoolName = intent.getStringExtra("schoolName")
        val className = intent.getStringExtra("className")
        val subject = intent.getStringExtra("subject")

        studentIdTextView.text = "Student ID: $studentId"
        schoolNameTextView.text = "School Name: $schoolName"
        classTextView.text = "Class: $className"
        subjectTextView.text = "Subject: $subject"

        submitButton.setOnClickListener {
            val intent = Intent(this, ToDo_List::class.java)
            Toast.makeText(this, "Submitted Successfully!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish() // Go back to Dashboard
        }
    }
}
