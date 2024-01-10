package com.example.watch.watch_features.presentation.timerScreen.components

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.watch.R
import com.example.watch.utils.LocalSpacing


@Composable
fun TimerSelector() {

    val spacing = LocalSpacing.current

    var hour by remember { mutableStateOf(0) }
    var minute by remember { mutableStateOf(0) }
    var second by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.medium),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AndroidView(
            modifier = Modifier.width(20.dp),
            factory ={ context ->
                NumberPicker(context).apply {
                    minValue = 0
                    maxValue = 12
                    setOnValueChangedListener { _, _, newVal ->
                        hour = newVal
                    }
                }
            }
        )

        Text(
            text = ":"
        )

        AndroidView(
            modifier = Modifier.width(20.dp),
            factory ={ context ->
                NumberPicker(context).apply {
                    minValue = 0
                    maxValue = 59
                    setOnValueChangedListener { _, _, newVal ->
                        minute = newVal
                    }
                }
            }
        )

        Text(
            text = ":"
        )

        AndroidView(
            modifier = Modifier.width(20.dp),
            factory ={ context ->
                NumberPicker(context).apply {
                    minValue = 0
                    maxValue = 59
                    setOnValueChangedListener { _, _, newVal ->
                        second = newVal
                    }
                }
            }
        )

    }

}