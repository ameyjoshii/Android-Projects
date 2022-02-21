package com.example.firebasetesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signup: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signup)
        auth= FirebaseAuth.getInstance()

        signup.setOnClickListener{
            val inputEmail= email.text.toString()
            val inputPassword= password.text.toString()
            if (inputEmail.isEmpty())
                Toast.makeText(this, "Email empty", Toast.LENGTH_SHORT).show()
            registerUserInFirebase(inputEmail, inputPassword)
        }
    }

    private fun registerUserInFirebase(inputEmail: String, inputPassword: String) {
        auth.createUserWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener {
            if (it.isSuccessful){
                val userName= name.text.toString()
                addDataInFirestore( it.result?.user?.uid ,userName, inputEmail)
                Toast.makeText(this@RegisterActivity, "Registered successfully", Toast.LENGTH_LONG).show()
                finish()
            }
            else{
                Toast.makeText(this@RegisterActivity, "$inputEmail is already registered", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addDataInFirestore(uid: String?, userName: String, inputEmail: String) {
        val user= User(uid!!, userName, inputEmail)
        UserDao().addUser(user)
    }
}