package com.example.bookmycar.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CarSpecification(){
    Column(modifier = Modifier.height(200.dp).padding(0.dp,10.dp,0.dp,10.dp).fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }
            Column(modifier = Modifier) {
                CarSpecs(icon = Icons.Default.Add, value = "Auto")
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarSpecs(icon: ImageVector, value:String){
    Card(modifier = Modifier
        .height(80.dp)
        .width(80.dp),
        shape = RoundedCornerShape(20.dp)) {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = icon, contentDescription = "value")
                }
                Row() {
                    Text(text = value, textAlign = TextAlign.Center, fontSize = 16.sp)
                }
            }
    }
}
