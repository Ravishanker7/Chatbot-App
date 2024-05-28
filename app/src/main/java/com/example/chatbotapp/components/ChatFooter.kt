package com.example.chatbotapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.FloatingWindow
import com.example.chatbotapp.R
import com.example.chatbotapp.Screens.color
import com.example.chatbotapp.ui.theme.rubikRegular

@Preview(showBackground = true)
@Composable
fun ChatFooter(onclick : (text : String)->Unit={} )
{

    var inputText by remember {
        mutableStateOf("")
    }
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = "#f2efe4".color)
            .padding(10.dp))
    {
        OutlinedTextField(value = inputText, onValueChange ={
            inputText=it
        },
            placeholder = {
            Text(text = "Ask me anything",
                fontFamily = rubikRegular)},
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .background(Color.White))

        IconButton(onClick = { onclick(inputText)
        inputText=""}){
            Icon(imageVector = Icons.Default.Send, contentDescription ="" ,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .padding(8.dp),
                tint = Color.White)
        }
    }
}