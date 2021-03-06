package com.example.comin.Utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUtils {

    companion object{

        private val auth = FirebaseAuth.getInstance()
        var db = FirebaseFirestore.getInstance()

        fun getUid() : String{
            return  auth.currentUser?.uid.toString()
        }

        fun getDB() : FirebaseFirestore{
            return db
        }

    }

}