package com.example.watch.watch_features.presentation.welcomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.watch.core.navigation.Screens
import com.example.watch.watch_features.presentation.welcomeScreen.components.Pager
import com.example.watch.watch_features.presentation.welcomeScreen.components.StartButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages by viewModel.listOfPages
    val pageState = rememberPagerState()

    Surface(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalPager(
                count = pages.size,
                state = pageState,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(10f)
            ) { count ->
                Pager(page = pages[count])
            }

            HorizontalPagerIndicator(
                pagerState = pageState,
                indicatorHeight = 4.dp,
                indicatorWidth = 18.dp,
                activeColor = MaterialTheme.colors.primary,
                inactiveColor = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
            )

            StartButton(
                pageState = pageState,
                modifier = Modifier.weight(2f)
            ) {
//                navController.popBackStack()
                viewModel.saveOnBoarding(complete = true)
                navController.navigate(Screens.ClockScreen.route)

            }

        }

    }

}




