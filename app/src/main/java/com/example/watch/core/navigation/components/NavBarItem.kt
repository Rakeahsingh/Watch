package com.example.watch.core.navigation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watch.utils.LocalSpacing

@Composable
fun NavBarItem(
    item: NavBarHolder,
    isSelected: Boolean,
    onClick: () -> Unit
) {

//    val spacing = LocalSpacing.current

    val backgroundColor =  if (isSelected) MaterialTheme.colors.onSurface.copy(alpha = 0.1f) else Color.Transparent

    val contentColor = if (isSelected) MaterialTheme.colors.onSurface else Color.Gray

    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable { onClick() }
    ){

        Row(
            modifier = Modifier
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                tint = contentColor,
                contentDescription = item.title,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.padding(horizontal = 0.dp))

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center,
                    color = contentColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }



}