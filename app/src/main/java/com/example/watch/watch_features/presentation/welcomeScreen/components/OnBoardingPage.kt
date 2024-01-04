package com.example.watch.watch_features.presentation.welcomeScreen.components

import androidx.annotation.DrawableRes
import com.example.watch.R

sealed class OnBoardingPage(
    @DrawableRes
    val icon: Int,
    val title: String,
    val description: String
) {

    object FirstPage: OnBoardingPage(
        R.drawable.onboarding1,
        "Secure Your Time",
        "We Secure our Time in this Single App"
    )

    object SecondPage: OnBoardingPage(
        R.drawable.onboarding2,
        "Secure Your Time",
        "We Secure our Time in this Single App"
    )

    object ThirdPage: OnBoardingPage(
        R.drawable.onboarding3,
        "Secure Your Time",
        "We Secure our Time in this Single App"
    )

}