package com.example.watch.watch_features.presentation.welcomeScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.watch_features.domain.use_Case.writeDataSoreUseCase.EditOnBoardingUseCase
import com.example.watch.watch_features.presentation.welcomeScreen.components.OnBoardingPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val editOnBoardingUseCase: EditOnBoardingUseCase
): ViewModel() {

    val listOfPages: State<List<OnBoardingPage>> = mutableStateOf(
        listOf(
            OnBoardingPage.FirstPage,
            OnBoardingPage.SecondPage,
            OnBoardingPage.ThirdPage
        )
    )

    fun saveOnBoarding(complete: Boolean){
        viewModelScope.launch {
            editOnBoardingUseCase(complete)
        }
    }

}