package com.example.firebasetesting

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class UserDao {

    private val db= FirebaseFirestore.getInstance()
    private val usersCollection= db.collection("users")

    fun addUser(user: User?){
        if (user!=null){
            usersCollection.document(user.uid).set(user)
        }
    }

    fun getUserById(uid: String): Task<DocumentSnapshot> {
        return usersCollection.document(uid).get()
    }
}