package com.example.watch.core.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.watch.core.navigation.components.BottomNavBar
import com.example.watch.core.navigation.components.provideBottomNavItem

@Composable
fun MainNavigation(
    startDestination: String
) {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    val rootDestination = listOf(
        Screens.ClockScreen.route,
        Screens.StopWatchScreen.route,
        Screens.TimerScreen.route,
    )

    val bottomNavState = remember { mutableStateOf(true) }

    val navBarEntry by navController.currentBackStackEntryAsState()
    bottomNavState.value = rootDestination.contains(navBarEntry?.destination?.route)


    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomNavState.value,
                enter = slideInVertically(initialOffsetY = { it }) ,
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                BottomNavBar(
                    navController = navController,
                    items = provideBottomNavItem(),
                ){
                    navController.navigate(it.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        },
        scaffoldState = scaffoldState
    ) {

        Box(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding()),
            contentAlignment = Alignment.Center
        ){

            NavGraphBuilder(
                navController = navController,
                startDestination = startDestination
            )

        }
    }

}