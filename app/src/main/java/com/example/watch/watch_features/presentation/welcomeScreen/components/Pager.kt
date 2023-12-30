package com.example.watch.watch_features.presentation.welcomeScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.watch.utils.LocalSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@Composable
fun Pager(
    page: OnBoardingPage
) {

    val spacing = LocalSpacing.current

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(
            painter = painterResource(id = page.icon),
            contentDescription = page.title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.6f)
        )

        Spacer(modifier = Modifier.height(spacing.medium))

        Text(
            text = page.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun StartButton(
    pageState: PagerState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth(.8f),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AnimatedVisibility(
            modifier = modifier
                .fillMaxWidth(),
            visible = pageState.pageCount == 2
        ) {

           Button(onClick = {
               onClick()
           },
              colors = ButtonDefaults.buttonColors(
                  backgroundColor = MaterialTheme.colors.primary,
                  contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primary)
              ),
               contentPadding = PaddingValues(
                   vertical = 12.dp
               )
           ) {
               Text(
                   text = "Finish",
                   style = MaterialTheme.typography.button
               )

           }

        }

    }

}