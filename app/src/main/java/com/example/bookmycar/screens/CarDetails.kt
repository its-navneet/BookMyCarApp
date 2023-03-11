package com.example.bookmycar.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmycar.component.AutoSliding
import com.example.bookmycar.component.CarSpecification
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun CarDetails(){
    Surface(){
        Column(modifier = Modifier.fillMaxSize()) {
            AutoSliding()
            CarSpecification()
            BookCarBottom(price = 200)
        }
    }
}

@Composable
fun BookCarBottom(price:Int){
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
        Column(modifier = Modifier
            .weight(1f)
            .height(60.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Row() {
                Text(text = "Rs $price", fontSize = 22.sp,textAlign = TextAlign.Center,fontWeight = FontWeight.Bold)
                Text(text = "/hr", textAlign = TextAlign.Center)
            }
        }
        Column(modifier = Modifier
            .weight(1f)
            .height(60.dp)) {
            Card(modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(20.dp,0.dp,0.dp,0.dp), backgroundColor = MaterialTheme.colors.primary) {
                Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                    Text(text = "Book", fontWeight = FontWeight.ExtraBold, color = Color.White, fontSize = 20.sp)
                }
            }
        }
    }
}

