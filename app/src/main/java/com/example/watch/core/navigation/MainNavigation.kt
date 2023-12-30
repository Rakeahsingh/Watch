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
        Screens.HomeScreen.route,
        Screens.StopWatchScreen.route,
        Screens.TimerScreen.route
    )

    val bottomNavState = remember { mutableStateOf(true) }

    val backStateEntry by navController.currentBackStackEntryAsState()

    bottomNavState.value = rootDestination.contains(backStateEntry?.destination?.route)
    
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            AnimatedVisibility(
                visible = bottomNavState.value,
                enter = slideInVertically(initialOffsetY = {it}),
                exit = slideOutVertically(targetOffsetY = {it})
            ) {
                BottomNavBar(
                    navController = navController,
                    items = provideBottomNavItem(),
                    onItemClick = {
                        navController.navigate(it.route)

                    }
                )
            }
        }
    ) {

        Box(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding()),
            contentAlignment = Alignment.Center
        ){

            MainNavigation(
                startDestination = startDestination
            )

        }
        
    }

}