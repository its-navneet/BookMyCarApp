package com.example.bookmycar.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.bookmycar.Car
import com.example.bookmycar.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Car(carList:List<Car>){
    val navController = rememberNavController()
    LazyRow{
        itemsIndexed(carList) { index, item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(160.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = 6.dp,
                onClick = {
                    navController.navigate("cardetails")
                }
            ){
                Image(painter = painterResource(id = item.image), contentDescription = "Csdsdcsd")
            }
        }

    }
}

@Composable
fun carListRow(capacity:Int){
    lateinit var carList: List<Car>
    carList = ArrayList<Car>()
    carList=carList+Car("sdcdcsad", R.drawable.car)
    carList=carList+Car("sdcdcsad", R.drawable.car2)
    carList=carList+Car("sdcdcsad", R.drawable.car3)
    carList=carList+Car("sdcdcsad", R.drawable.car4)
    carList=carList+Car("sdcdcsad", R.drawable.car5)
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "$capacity seater", modifier = Modifier.padding(8.dp))
        Car(carList)
    }
}