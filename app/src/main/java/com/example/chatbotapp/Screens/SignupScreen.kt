package com.example.chatbotapp.Screens

import android.content.ContentValues.TAG
import android.graphics.Color.parseColor
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatbotapp.NavController.Routes
import com.example.chatbotapp.R
import com.example.chatbotapp.ui.theme.customColor
import com.example.chatbotapp.ui.theme.rubikFontFamily
import com.example.chatbotapp.ui.theme.rubikRegular
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlin.math.round


@Composable
fun SignupScreen(navController: NavController) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = "#f2efe4".color)
        )
    {

        var email by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }


        Column(modifier = Modifier.fillMaxSize()
            .background(color = "#f2efe4".color),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(20.dp))

            Image(painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp))

            Spacer(modifier = Modifier.height(20.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription ="",
                modifier = Modifier
                    .size(200.dp))

            Text(text = "Welcome to Chatty Charm",
                fontSize = 25.sp,
                fontFamily = rubikFontFamily,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Create a free Chatty Charm account \n and ignite your curiosity",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = rubikRegular,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = email , onValueChange ={
                email=it
            }, label = { Text(text = "Email Address")} )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = password, onValueChange ={
                password=it
            } , label = { Text(text = "Password")})

            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = {
                             if(validate(email,password)){
                                 CreateUserUnFirebase(email,password)
                                 navController.navigate(Routes.chat)
                             }else{
                                 Log.d(TAG,"Failed")
                             }
            },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                ), shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp)) {
                Text(text = "Create FREE account")
            }

            TextButton(onClick = { navController.navigate(Routes.Login) }) {
                Text(text = "Already have an account? Login",
                    fontWeight = FontWeight.Medium,
                    fontFamily = rubikRegular,
                    color = Color.Black
                )
            }

        }
    }
}


fun validate(email : String, password: String) : Boolean{
    if(email.length<6 || password.length<6){
        return false
    }else{
        return true
    }
}


private fun CreateUserUnFirebase(username: String,password : String){
    FirebaseAuth.getInstance()
        .createUserWithEmailAndPassword(username,password)
        .addOnSuccessListener {
            Log.d(TAG,"${it.user}")
        }

        .addOnFailureListener {
            Log.d(TAG,"${it.cause}")
        }
}

val String.color
    get() = Color(parseColor(this))