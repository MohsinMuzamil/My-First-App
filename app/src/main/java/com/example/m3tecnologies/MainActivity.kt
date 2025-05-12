package com.example.m3tecnologies

import android.content.Intent
import android.widget.CheckBox
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var resetButton: Button
    private lateinit var rememberMeCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        resetButton = findViewById(R.id.resetButton)
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox)

        // Restore checkbox state
        val pref = getSharedPreferences("Login", MODE_PRIVATE)
        val isRemembered = pref.getBoolean("flag", false)
        rememberMeCheckBox.isChecked = isRemembered

        // Login button with validation
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            } else {
                // Save login flag based on checkbox
                val editor = pref.edit()
                editor.putBoolean("flag", rememberMeCheckBox.isChecked)
                editor.apply()

                // Move to dashboard
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
                finish()
            }
        }

        // Reset button clears both fields
        resetButton.setOnClickListener {
            emailEditText.text.clear()
            passwordEditText.text.clear()
            rememberMeCheckBox.isChecked = false
        }
    }
}
