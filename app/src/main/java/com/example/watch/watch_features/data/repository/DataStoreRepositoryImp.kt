package com.example.watch.watch_features.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.watch.core.Constants
import com.example.watch.watch_features.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "expense_key_store")
class DataStoreRepositoryImp @Inject constructor(
    context: Context
): DataStoreRepository {

    private val dataStore = context.dataStore

    private val onBoardingKey = booleanPreferencesKey(Constants.WELCOME_KEY)
    override suspend fun writeOnBoardingKeyDataStore(complete: Boolean) {
        dataStore.edit { store ->
            store[onBoardingKey] = complete
        }
    }

    override suspend fun readOnBoardingKeyDataStore(): Flow<Boolean> {
        val preference = dataStore.data
        return flow {
            preference.collect{ pref ->
                emit(pref[onBoardingKey] ?: false)
            }
        }
    }
}