package com.example.watch.watch_features.domain.use_Case.readDataSoreUseCase

import com.example.watch.watch_features.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnBoardingUseCase @Inject constructor(
    private val repository: DataStoreRepository
){

    suspend operator fun invoke(): Flow<Boolean>{
        return repository.readOnBoardingKeyDataStore()
    }

}