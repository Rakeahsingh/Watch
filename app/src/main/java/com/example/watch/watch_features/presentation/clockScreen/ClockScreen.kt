package com.example.watch.watch_features.presentation.clockScreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.watch.utils.LocalSpacing
import com.example.watch.watch_features.presentation.clockScreen.components.AnalogClock
import com.example.watch.watch_features.presentation.clockScreen.components.HeaderText
import com.example.watch.watch_features.presentation.clockScreen.components.TimerText
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun ClockScreen() {

    val spacing = LocalSpacing.current

    var hour by remember { mutableStateOf("0") }
    var min by remember { mutableStateOf("0") }
    var sec by remember { mutableStateOf("0") }
    var amOrPm by remember { mutableStateOf("0") }

    LaunchedEffect(Unit){
        while (true){
            val cal = Calendar.getInstance()
            hour = cal.get(Calendar.HOUR).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            min = cal.get(Calendar.MINUTE).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            sec = cal.get(Calendar.SECOND).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            amOrPm = cal.get(Calendar.AM_PM).run {
                if (this == Calendar.AM) "AM" else "PM"
            }
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(spacing.large))

        HeaderText("Clock")

        Spacer(modifier = Modifier.height(spacing.medium))

        AnalogClock(
            hour = hour.toInt(),
            min = min.toInt(),
            sec = sec.toInt()
        )


        Spacer(modifier = Modifier.height(spacing.large))

        TimerText(
            hour,
            min,
            amOrPm
        )


    }

}


