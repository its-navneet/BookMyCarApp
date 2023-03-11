package com.example.bookmycar

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: String
)

val BottomNavItems = listOf(
    BottomNavItem(
        label = "Home",
        icon = R.drawable.home,
        route = "home"
    ),
    BottomNavItem(
        label = "Category",
        icon = R.drawable.history,
        route = "category"
    )
)