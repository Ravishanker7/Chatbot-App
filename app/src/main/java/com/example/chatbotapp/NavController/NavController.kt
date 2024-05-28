package com.example.chatbotapp.NavController

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatbotapp.ChatBot
import com.example.chatbotapp.Screens.LoginScreen
import com.example.chatbotapp.Screens.ProfileScreen
import com.example.chatbotapp.Screens.SignupScreen
import com.example.chatbotapp.components.ChatHeader
import com.google.firebase.auth.FirebaseAuth


@Composable
fun NavController(){
    val navContoller= rememberNavController()
    val user = FirebaseAuth.getInstance().currentUser
    if (user != null) {
        ChatBot()
    } else {
        NavHost(navController = navContoller, startDestination =Routes.Signup, builder = {
            composable(Routes.Signup){
                SignupScreen(navContoller)
            }
            composable(Routes.Login){
                LoginScreen(navContoller)
            }
            composable(Routes.chat){
                ChatBot()
            }
            composable(Routes.Proflle){
                ProfileScreen(navContoller)
            }
        } )
        // No user is signed in
    }

}