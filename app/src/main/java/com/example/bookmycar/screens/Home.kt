package com.example.bookmycar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookmycar.component.*

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
    ) {
        
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                Greeting(name = "Navneet")
            }
            Column(modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
                ProfileIcon()
            }
        }

        ChooseCarGreeting()

        carBrandRow()
        carListRow(4)
        carListRow(6)
        carListRow(7)
    }

}