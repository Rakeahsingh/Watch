package com.example.watch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.watch.ui.theme.WatchTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.watch.core.navigation.MainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                    val viewModel = hiltViewModel<MainViewModel>()
                    val startDestination = viewModel.startDestination.collectAsState()

                    MainNavigation(startDestination = startDestination )

               }
            }
        }
    }
}

