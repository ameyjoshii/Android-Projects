package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Signup : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var signup: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        name = findViewById(R.id.name)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signup)

        signup.setOnClickListener{
            val userName = username.text.toString()
            val passWord = password.text.toString()
            val naMe = name.text.toString()

            checkValid(userName,passWord,naMe)
        }
    }

    private fun checkValid(userName: String,passWord: String,naMe: String){
        if(userName != "" && passWord != ""  && naMe != ""){
            Toast.makeText(this,"Sign Up Complete", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Enter Valid Credentials",Toast.LENGTH_LONG).show()
        }
    }

}