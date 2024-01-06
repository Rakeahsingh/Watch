package com.example.watch.watch_features.presentation.clockScreen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun HeaderText(
    text: String
) {

    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.Bold
    )

}