package com.example.watch.core.navigation.components

import com.example.watch.R
import com.example.watch.core.navigation.Screens

data class NavBarHolder(
    val title: String,
    val icon: Int,
    val route: String
)

fun provideBottomNavItem() = listOf(

    NavBarHolder(
        "Home",
        R.drawable.img_2,
        Screens.HomeScreen.route
    ),

    NavBarHolder(
        "StopWatch",
        R.drawable.img_1,
        Screens.StopWatchScreen.route
    ),

    NavBarHolder(
        "Timer",
        R.drawable.img,
        Screens.TimerScreen.route
    )

)