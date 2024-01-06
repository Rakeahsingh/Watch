package com.example.watch.watch_features.presentation.clockScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TimerText(
    hour: String,
    minute: String,
    amOrPm: String
) {

    Column {
        Text(
            text = "$hour:$minute $amOrPm",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = " Kirari, Delhi",
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(
                    color = MaterialTheme.colorScheme.onBackground.copy(
                        alpha = 0.6f
                    )
                )
            ),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Light
        )
    }




}