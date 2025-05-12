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
import androidx.appcompat.widget.SwitchCompat

class DashboardActivity : AppCompatActivity() {

    lateinit var logoutButton: Button
    lateinit var nextButton: Button
    lateinit var welcomeTextView: TextView
    lateinit var studentIdEditText: EditText
    lateinit var schoolNameEditText: EditText
    lateinit var classEditText: EditText
    lateinit var subjectSpinner: Spinner
    private lateinit var bulbImage: ImageView
    private lateinit var onBulbSwitch: SwitchCompat  // Use SwitchCompat instead of two buttons

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
        onBulbSwitch = findViewById(R.id.on_bulb_btn)  // SwitchCompat instance

        // Get email from intent and display welcome message
        val email = intent.getStringExtra("email")
        welcomeTextView.text = "Welcome, $email"

        logoutButton.setOnClickListener {
            // Log out logic, clearing shared preferences and going back to login screen
            val pref = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = pref.edit()
            editor.putBoolean("flag", false)
            editor.apply() // Go back to login

            val intent = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Set up the spinner for subject selection
        val subjectAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.subject_list,
            android.R.layout.simple_spinner_item
        )
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner.adapter = subjectAdapter

        // Handle bulb state change based on the switch
        onBulbSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                bulbImage.setImageResource(R.drawable.on_bulb)  // Show the bulb on
            } else {
                bulbImage.setImageResource(R.drawable.off_bulb)  // Show the bulb off
            }
        }

        // Handle next button click, pass data to SubmitActivity
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
