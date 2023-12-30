package com.example.watch.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.watch.core.navigation.Screens
import com.example.watch.watch_features.presentation.homeScreen.HomeScreen
import com.example.watch.watch_features.presentation.stopWatchScreen.StopWatchScreen
import com.example.watch.watch_features.presentation.timerScreen.TimerScreen

@Composable
fun NavGraphBuilder(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){

        composable(Screens.HomeScreen.route){
            HomeScreen()
        }

        composable(Screens.StopWatchScreen.route){
            StopWatchScreen()
        }

        composable(Screens.TimerScreen.route){
            TimerScreen()
        }

    }

}