package com.example.firebasetesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcome: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        welcome= findViewById(R.id.welcome)
        auth= FirebaseAuth.getInstance()

        showDetails()
    }

    private fun showDetails() {
        UserDao().getUserById(auth.currentUser?.uid.toString()).addOnCompleteListener {
            val currentUser= it.result?.toObject(User::class.java)
            welcome.text= "Welcome ${currentUser?.name} logged in using ${currentUser?.email}"
        }
    }

    fun logoutClicked(view: View) {
        auth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}