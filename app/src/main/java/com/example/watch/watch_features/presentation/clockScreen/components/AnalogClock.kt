package com.example.watch.watch_features.presentation.clockScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.example.watch.ui.theme.businessBg
import com.example.watch.ui.theme.electricBg
import com.example.watch.ui.theme.giftBg
import com.example.watch.ui.theme.subBg
import kotlin.math.min

@Composable
fun AnalogClock(
    hour: Int,
    min: Int,
    sec: Int
) {

    Box(
        modifier = Modifier
            .fillMaxSize(0.6f)
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(electricBg),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()

        ){
            val diameter = min(size.width, size.height) * 0.9f
            val radius = diameter / 2


            repeat(4){
                val start = center - Offset(0f, radius)
                val end = start + Offset(0f, radius / 40f)

                rotate(it / 4f * 360){

                    drawLine(
                        color = Color.White,
                        start = start,
                        end = end,
                        strokeWidth = 5.dp.toPx(),
                        cap = StrokeCap.Round
                    )

                }
            }

            val secondRatio = sec / 60f
            val minuteRatio = min / 60f
            val hourRatio = hour / 12f

            rotate(hourRatio * 360, center){
                drawLine(
                    color = Color.Black,
                    start = center - Offset(0f, radius * 0.4f),
                    end = center + Offset(0f, radius * 0.1f),
                    strokeWidth = 3.8.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }

            rotate(minuteRatio * 360, center){
                drawLine(
                    color = businessBg,
                    start = center - Offset(0f, radius * 0.6f),
                    end = center + Offset(0f, radius * 0.1f),
                    strokeWidth = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }


            rotate(secondRatio * 360, center){
                drawLine(
                    color = subBg,
                    start = center - Offset(0f, radius * 0.8f),
                    end = center + Offset(0f, radius * 0.1f),
                    strokeWidth = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }


            drawCircle(
                color = giftBg,
                radius = 5.dp.toPx(),
                center = center
            )


        }

    }

}