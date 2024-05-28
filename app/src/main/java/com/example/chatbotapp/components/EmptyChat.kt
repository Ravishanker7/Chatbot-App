package com.example.chatbotapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbotapp.R
import com.example.chatbotapp.Screens.color
import com.example.chatbotapp.ui.theme.rubikFontFamily
import com.example.chatbotapp.ui.theme.rubikRegular

@Preview(showBackground = true)
@Composable
fun EmptyChat() {
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(color = "#f2efe4".color)){

        Image(painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(10.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Chatty Charm", fontFamily = rubikFontFamily,
            fontSize = 32.sp)

        Text(text = "I'm here to help you with whatever you \n " +
                "need, from answering questions to \n " +
                "providing recommendations. Let's chat!",
            fontFamily = rubikRegular, fontSize = 15.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Example: Some text example \n" +
                  " goes in here",
            fontFamily = rubikRegular, fontSize = 15.sp,
            textAlign = TextAlign.Center)
    }
}