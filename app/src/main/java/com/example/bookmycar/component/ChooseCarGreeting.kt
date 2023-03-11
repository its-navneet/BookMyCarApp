package com.example.bookmycar.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseCarGreeting(){
    Text(text = "Lets choose your car", fontSize = 20.sp, modifier = Modifier.padding(15.dp,5.dp,15.dp,10.dp))
}