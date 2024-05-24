package com.example.chatbotapp

sealed interface ChatBotUIState {
    data object Ideal : ChatBotUIState

    data object Loading : ChatBotUIState

    data class Success(val ChatData : String) :ChatBotUIState

    data class Error(val chatError : String) : ChatBotUIState
}