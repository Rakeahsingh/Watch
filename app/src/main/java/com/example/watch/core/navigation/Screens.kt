package com.example.watch.core.navigation

sealed class Screens(val route: String) {

    object WelcomeScreen: Screens("welcome")

    object HomeScreen : Screens("home")

    object StopWatchScreen: Screens("stopWatch")

    object TimerScreen: Screens("timer")

}