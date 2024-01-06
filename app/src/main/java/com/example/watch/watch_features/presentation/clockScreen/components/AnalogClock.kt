package com.example.watch.watch_features.presentation.clockScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AnalogClock(
    hour: Int,
    min: Int,
    sec: Int
) {

    Box(
        modifier = Modifier.fillMaxSize(006f),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()
        ){

        }

    }

}