package com.example.chatbotapp.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatbotapp.NavController.Routes
import com.example.chatbotapp.Screens.color


@Composable
fun ChatHeader() {
    Row(modifier = Modifier.fillMaxWidth()
        .background(color = "#f2efe4".color),
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = Icons.Default.List, contentDescription = null,
            modifier = Modifier.size(60.dp).padding(10.dp))
        Spacer(modifier = Modifier.fillMaxWidth(0.8f))
        IconButton(onClick = {

        }) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null,
                modifier = Modifier.size(80.dp).padding(5.dp))
        }
    }
}