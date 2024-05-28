package com.example.chatbotapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatbotapp.NavController.Routes
import com.example.chatbotapp.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .background(color = "#f2efe4".color)
            .fillMaxSize()
            .padding(8.dp)
    )
    {
        var email by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }

        val auth=FirebaseAuth.getInstance()

        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = "#f2efe4".color),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
            )

            Text(
                text = "Welcome to Chatty Charm",
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Login In to your Chatty Charm account \n and ignite your curiosity",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = email, onValueChange = {
                email = it
            }, label = { Text(text = "Email Address") })
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, label = { Text(text = "Password") })

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                          if(SignUpintoFirebase(email,password)){
                              navController.navigate(Routes.chat)
                }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                ), shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp)
            ) {
                Text(text = "Login")
            }

        }
    }
}

private fun SignUpintoFirebase(email:String, passowrd: String) : Boolean{
    var checkk=false;
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,passowrd)
        .addOnSuccessListener {
            checkk=true
        }
        .addOnFailureListener {
            checkk=false
        }
    return checkk
}

