package com.example.hsicoffeeproject

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class LoginFlowApp : Application(){

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}