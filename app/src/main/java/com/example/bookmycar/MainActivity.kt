package com.example.bookmycar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookmycar.screens.CarDetails
import com.example.bookmycar.screens.HistoryScreen
import com.example.bookmycar.screens.HomeScreen
import com.example.bookmycar.ui.theme.BookMyCarTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookMyCarTheme() {
                val context = LocalContext.current
                val navController = rememberNavController()
                var showBottomBar by rememberSaveable { mutableStateOf(true) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                showBottomBar = when (navBackStackEntry?.destination?.route) {
                    "cardetails" -> false
                    else -> true
                }

                Scaffold(
                    bottomBar = {
                        if (showBottomBar){
                            BottomAppBar(
                                modifier = Modifier
                                    .height(65.dp),
                                cutoutShape = CircleShape,
                                backgroundColor = MaterialTheme.colors.surface,
                                elevation = 10.dp,
                            ) {
                                BottomNavigationBar(navController = navController)
                            }
                        }
                    }, content = { padding ->
                        NavHostContainer(navController = navController, padding = padding)
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = {
                        if (showBottomBar){
                            FloatingActionButton(
                                shape = CircleShape,
                                onClick = {
                                    navController.navigate("cardetails")
                                },
                                contentColor = MaterialTheme.colors.surface
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "add",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                )

            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            // route : Home
            composable("home") {
                HomeScreen()
            }

            // route : furniture
            composable("category") {
                HistoryScreen()
            }

            composable("cardetails"){
                CarDetails()
            }
        })

}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        // set background color
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    ) {

        // observe the backstack
        val navBackStackEntry  by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                unselectedContentColor = MaterialTheme.colors.onSurface,
                selectedContentColor = MaterialTheme.colors.primary,
                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route){
                        popUpTo(
                            navController.graph.startDestinationId
                        )
                        launchSingleTop = true
                    }
                },

                // Icon of navItem
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = navItem.label,
                        modifier = Modifier
                            .size(25.dp)
                    )
                },
                alwaysShowLabel = false
            )
        }
    }
}