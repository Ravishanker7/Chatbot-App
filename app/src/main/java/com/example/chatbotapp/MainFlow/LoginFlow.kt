package com.example.chatbotapp.MainFlow

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase

class LoginFlow : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}