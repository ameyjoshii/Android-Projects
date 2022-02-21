package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcometxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        welcometxt = findViewById(R.id.welcome)

        val name = intent.getStringExtra("Name")
        welcometxt.text = "Welcome $name"

    }
}