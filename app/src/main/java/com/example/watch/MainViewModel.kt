package com.example.watch

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.core.navigation.Screens
import com.example.watch.watch_features.domain.use_Case.readDataSoreUseCase.GetOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("SuspiciousIndentation")
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getOnBoardingUseCase: GetOnBoardingUseCase
): ViewModel() {

    var isLoading = MutableStateFlow(true)
        private set

    var startDestination = MutableStateFlow(Screens.WelcomeScreen.route)
        private set

    init {
        viewModelScope.launch {
            getOnBoardingUseCase().collect { complete ->
                if(complete)
                startDestination.value = Screens.ClockScreen.route
            }
            isLoading.value = false
        }
    }

}