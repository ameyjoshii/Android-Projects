package com.example.firebasetesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.inputEmail)
        password = findViewById(R.id.inputPassword)
        login = findViewById(R.id.login)
        auth= FirebaseAuth.getInstance()

        login.setOnClickListener {
            val emailText= email.text.toString()
            val passwordText= password.text.toString()
            checkCredentials(emailText, passwordText)
        }
    }

    private fun checkCredentials(emailText: String, passwordText: String) {
        if (emailText.isNotEmpty() && passwordText.isNotEmpty()){
            auth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, WelcomeActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun registerClicked(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}