package com.example.bookmycar.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.example.bookmycar.R

@Composable
fun Greeting(name:String){
    Text(text = "Hi, $name", fontSize = 25.sp, fontStyle = FontStyle(R.font.greeting))
}