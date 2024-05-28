package com.example.chatbotapp.Screens

import android.graphics.drawable.Icon
import androidx.collection.ArrayMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatbotapp.NavController.Routes
import com.example.chatbotapp.ui.theme.rubikRegular


@Composable
fun ProfileScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()
        .background(color = "#f2efe4".color)
        .padding(10.dp),) {
        header(onClick = {
            navController.navigate(Routes.chat)
        })

        Icon(imageVector = Icons.Default.AccountBox, contentDescription =null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally))

        Text(text = "Ravi shanker",
        modifier = Modifier.align(Alignment.CenterHorizontally))

        customList("Edit profile", Icons.Default.Person)

        customList("Notifications", Icons.Default.Notifications)

        customList("Languages", Icons.Default.Menu)

        customList(text = "Terms and Service", imagee =Icons.Default.MailOutline )

        customList(text = "Privacy Policy", imagee =Icons.Default.Menu )

        customList(text = "Logout", imagee =Icons.Default.ExitToApp )
    }
}

@Composable
fun header(onClick : () -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null,
            modifier = Modifier.clickable {
                onClick()
            })
        Spacer(modifier = Modifier.fillMaxWidth(0.4f))
        Text(text = "Profile",
            textAlign = TextAlign.Center,
            fontFamily = rubikRegular)
    }
}

@Composable
fun customList(text : String, imagee: ImageVector){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = imagee,
            contentDescription =null,
            modifier = Modifier.size(30.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text,
            textAlign = TextAlign.Center,
            fontFamily = rubikRegular)

        Spacer(modifier = Modifier.fillMaxWidth(0.8f))
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription =null ,
            )
    }
}