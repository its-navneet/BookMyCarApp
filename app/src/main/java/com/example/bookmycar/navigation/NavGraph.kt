package com.example.bookmycar.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookmycar.screens.CarDetails

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "home",
        modifier = Modifier,

        builder = {
            composable("cardetails"){
                CarDetails()
            }
        })

}