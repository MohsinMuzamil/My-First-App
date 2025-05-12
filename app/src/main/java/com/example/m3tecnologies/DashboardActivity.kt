// src/main/java/yourpackage/DashboardActivity.kt
package com.example.m3tecnologies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.ImageView



class DashboardActivity : AppCompatActivity() {

    lateinit var logoutButton: Button
    lateinit var nextButton: Button
    lateinit var welcomeTextView: TextView
    lateinit var studentIdEditText: EditText
    lateinit var schoolNameEditText: EditText
    lateinit var classEditText: EditText
    lateinit var subjectEditText: EditText
    lateinit var subjectSpinner: Spinner
    private lateinit var bulbImage: ImageView
    private lateinit var onButton: Button
    private lateinit var offButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        logoutButton = findViewById(R.id.logoutButton)
        nextButton = findViewById(R.id.nextButton)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        studentIdEditText = findViewById(R.id.studentIdEditText)
        schoolNameEditText = findViewById(R.id.schoolNameEditText)
        classEditText = findViewById(R.id.classEditText)
        subjectSpinner = findViewById(R.id.subjectSpinner)
        bulbImage = findViewById(R.id.bulbImage)
        onButton = findViewById(R.id.on_bulb_btn)
        offButton = findViewById(R.id.off_bulb_btn)

        val email = intent.getStringExtra("email")
        welcomeTextView.text = "Welcome, $email"

        logoutButton.setOnClickListener {

            val pref = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = pref.edit()
            editor.putBoolean("flag", false)
            editor.apply() // Go back to login

            val intent = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }



        val subjectAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.subject_list,
            android.R.layout.simple_spinner_item
        )
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner.adapter = subjectAdapter


        onButton.setOnClickListener {
            bulbImage.setImageResource(R.drawable.on_bulb)
        }

        offButton.setOnClickListener {
            bulbImage.setImageResource(R.drawable.off_bulb)
        }


        nextButton.setOnClickListener {
            val intent = Intent(this, SubmitActivity::class.java)
            val selectedSubject = subjectSpinner.selectedItem.toString()
            intent.putExtra("studentId", studentIdEditText.text.toString())
            intent.putExtra("schoolName", schoolNameEditText.text.toString())
            intent.putExtra("className", classEditText.text.toString())
            intent.putExtra("subject", selectedSubject)
            startActivity(intent)



        }
    }
}
