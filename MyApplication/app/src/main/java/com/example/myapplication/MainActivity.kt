package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//const val TAG = "ActivityLifecycle"
class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.uname)
        password = findViewById(R.id.pass)
        login = findViewById(R.id.login)
        signup = findViewById(R.id.signUp)

        login.setOnClickListener{
            val userUnameIp = username.text.toString()
            val userPassIp = password.text.toString()

            checkCredentials(userUnameIp,userPassIp)
        }

        signup.setOnClickListener{
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
//        Log.d(TAG,"OnCreate Called")
    }

    private fun checkCredentials(userUnameIp :String, userPassIp: String){
        if(userUnameIp == "admin" && userPassIp == "1234"){
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("Name","Admin!!")
            startActivity(intent)
        // Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show()
        }

    }






//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG,"OnStart Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG,"OnResume Called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG,"OnPause Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG,"OnStop Called")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG,"OnRestart Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG,"OnDestroy Called")
//    }
}
