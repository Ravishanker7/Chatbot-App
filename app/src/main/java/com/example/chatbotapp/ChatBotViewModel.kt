package com.example.chatbotapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotViewModel : ViewModel() {


    val list by lazy {
        mutableListOf<ChatData>()
    }
    private val genAi by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = "AIzaSyCASCpsH2m3iGfokXKbFp9FCUNJuPW3zGY"
        )
    }

    fun sendMessage(message : String)=viewModelScope.launch{

        val chat=genAi.startChat()

        list.add(ChatData(message,ChatRoleEnum.USER.role))

        chat.sendMessage(
            content(ChatRoleEnum.USER.role) { text(message) }
        ).text?.let {
            list.add(ChatData(it,ChatRoleEnum.MODEL.role))
        }
    }
}