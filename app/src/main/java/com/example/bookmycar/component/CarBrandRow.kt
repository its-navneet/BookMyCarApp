package com.example.bookmycar.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookmycar.CarBrand
import com.example.bookmycar.R

@Composable
fun carBrandRow(){
    lateinit var carBrandList: List<CarBrand>
    carBrandList = ArrayList()
    carBrandList=carBrandList+ CarBrand(R.drawable.mercedes)
    carBrandList=carBrandList+ CarBrand(R.drawable.skoda)
    carBrandList=carBrandList+ CarBrand(R.drawable.hyundai)
    carBrandList=carBrandList+ CarBrand(R.drawable.volkswagon)
    carBrandList=carBrandList+ CarBrand(R.drawable.kia)
    Column(modifier = Modifier.fillMaxWidth()) {
        carBrandList(carBrandList)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun carBrandList(carBrandList:List<CarBrand>){
    LazyRow{
        itemsIndexed(carBrandList) { index, item ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(80.dp)
                    .width(80.dp),
                shape = RoundedCornerShape(100.dp),
                elevation = 6.dp,
                onClick = {
                    println("hello $index")
                }
            ){
                Image(painter = painterResource(id = item.carLogo), contentDescription = "Csdsdcsd", contentScale = ContentScale.Fit, modifier = Modifier.padding(10.dp))
            }
        }

    }
}