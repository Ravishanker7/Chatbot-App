package com.example.chatbotapp

data class ChatData (
    val message: String,
    val role: String
)

enum class ChatRoleEnum(val role:String){
    USER("user"),
    MODEL("model")
}