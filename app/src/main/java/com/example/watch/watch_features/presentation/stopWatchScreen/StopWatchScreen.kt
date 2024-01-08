package com.example.watch.watch_features.presentation.stopWatchScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.watch.utils.LocalSpacing
import kotlinx.coroutines.delay

@Composable
fun StopWatchScreen() {

    val spacing = LocalSpacing.current

    var isRunning by remember { mutableStateOf(false) }
    var time by remember { mutableLongStateOf(0L) }

    LaunchedEffect(Unit){
        while(true){
            if (!isRunning){
                delay(1000)
                time++
            }
        }
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(CircleShape)
                .border(1.dp, Color.LightGray, CircleShape),
            contentAlignment = Alignment.Center,
        ){
            Text(
                text = formatTime(time),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(250.dp))


        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = spacing.extraLarge,
                    vertical = spacing.medium
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = {
                    isRunning = !isRunning
                },
                shape = CircleShape
            ) {
                if (isRunning)
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play")
                else
                    Icon(imageVector = Icons.Default.Pause, contentDescription = "Pause")
            }
            Button(
                onClick = {
                    time = 0
                },
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.RestartAlt, contentDescription = "Reset")
            }
        }

    }
}

fun formatTime(time: Long): String {
    val seconds = time % 60
    val minutes = (time / 60) % 60
    val hours = time / 3600
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}