package com.example.m3tecnologies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.content.Intent



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            // Access shared preferences
            val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
            val check = sharedPref.getBoolean("flag", false)

            // Decide next activity based on 'flag'
            val iNext = if (check) {
                Intent(this@SplashActivity, DashboardActivity::class.java)
            } else {
                Intent(this@SplashActivity, MainActivity::class.java)
            }

            startActivity(iNext)
            finish()

        }, 2000) // 2 second delay
    }
}
