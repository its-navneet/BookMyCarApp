package com.example.bookmycar.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookmycar.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileIcon(){
    Card(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp),
        shape = RoundedCornerShape(100.dp),
        elevation = 6.dp,
        onClick = {

        }
    ){
        Image(painter = painterResource(id = R.drawable.dummy), contentDescription = "profile",
            contentScale = ContentScale.Fit
        )
    }


}