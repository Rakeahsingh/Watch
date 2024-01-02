package com.example.watch.watch_features.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun writeOnBoardingKeyDataStore(complete: Boolean)

    suspend fun readOnBoardingKeyDataStore(): Flow<Boolean>

}