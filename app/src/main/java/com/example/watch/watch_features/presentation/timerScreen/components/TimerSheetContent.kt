package com.example.watch.watch_features.presentation.timerScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.geometry.Size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.watch.ui.theme.LightBlue500
import com.example.watch.ui.theme.Red500
import com.example.watch.utils.LocalSpacing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TimerSheetContent(
    modalBottomSheetState: ModalBottomSheetState,
    scope: CoroutineScope
) {

    val spacing = LocalSpacing.current

    var titleTextField by remember { mutableStateOf(TextFieldValue(String())) }
    var expandState by remember { mutableStateOf(false) }
    var size by remember { mutableStateOf(Size.Zero) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Add Timer",
            style = MaterialTheme.typography.subtitle2
        )

        TextField(
            value = titleTextField,
            onValueChange = {
                titleTextField = it
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = spacing.small,
                    horizontal = spacing.medium
                ),
            placeholder = {
                Text(
                    text = "Add Title"
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextButton(
            onClick = {
                scope.launch {
                    modalBottomSheetState.hide()
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LightBlue500,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "SAVE",
                style = MaterialTheme.typography.button
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                scope.launch {
                    modalBottomSheetState.hide()
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red500,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "CANCEL",
                style = MaterialTheme.typography.button
            )
        }

    }

}