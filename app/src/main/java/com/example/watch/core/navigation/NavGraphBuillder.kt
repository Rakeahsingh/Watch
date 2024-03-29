package com.example.watch.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.watch.watch_features.presentation.clockScreen.ClockScreen
import com.example.watch.watch_features.presentation.stopWatchScreen.StopWatchScreen
import com.example.watch.watch_features.presentation.timerScreen.TimerScreen
import com.example.watch.watch_features.presentation.welcomeScreen.WelcomeScreen

@Composable
fun NavGraphBuilder(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable(Screens.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }

        composable(Screens.ClockScreen.route){
            ClockScreen()
        }

        composable(Screens.StopWatchScreen.route){
            StopWatchScreen()
        }

        composable(Screens.TimerScreen.route){
            TimerScreen(navController = navController)
        }

    }

}