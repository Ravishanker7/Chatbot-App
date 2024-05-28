package com.example.chatbotapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbotapp.ChatData
import com.example.chatbotapp.ChatRoleEnum
import com.example.chatbotapp.Screens.color
import com.example.chatbotapp.ui.theme.rubikRegular

@Composable
fun ChatList(
    list: MutableList<ChatData>
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = "#f2efe4".color)
        .padding(10.dp)) {
        items(list){
            if(it.role==ChatRoleEnum.USER.role){
                Box (modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    )
                {
                    Text(
                        text = it.message,
                        modifier = Modifier
                            .padding(20.dp),
                        color = Color.Black,
                        fontFamily = rubikRegular,
                        fontSize = 18.sp,
                    )
                }
            }else{
                Box(modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)) {
                    Text(
                        text = it.message,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth(0.7f),
                        color = Color.Black,
                        fontFamily = rubikRegular,
                        fontSize = 18.sp,
                    )
                }

            }
        }
    }
}