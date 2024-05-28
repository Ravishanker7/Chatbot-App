package com.example.chatbotapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatbotapp.components.ChatFooter
import com.example.chatbotapp.components.ChatHeader
import com.example.chatbotapp.components.ChatList
import com.google.ai.client.generativeai.Chat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatbotapp.NavController.Routes
import com.example.chatbotapp.Screens.color
import com.example.chatbotapp.components.EmptyChat



@Composable
fun ChatBot(viewModel : ChatBotViewModel = viewModel()) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = "#f2efe4".color)
            .fillMaxSize()
            .padding(10.dp))
    {

        ChatHeader()

        Box(modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center)
        {
            if(viewModel.list.isEmpty()){
                EmptyChat()
            }else{
                ChatList(list = viewModel.list)
            }
        }

        ChatFooter {
            if(it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }
}