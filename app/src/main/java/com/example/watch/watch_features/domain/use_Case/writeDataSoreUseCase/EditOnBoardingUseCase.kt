package com.example.watch.watch_features.domain.use_Case.writeDataSoreUseCase

import com.example.watch.watch_features.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditOnBoardingUseCase @Inject constructor(
    private val repository: DataStoreRepository
){

    suspend operator fun invoke(complete: Boolean){
        repository.writeOnBoardingKeyDataStore(complete)
    }

}