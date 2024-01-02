package com.example.watch.di

import android.app.Application
import com.example.watch.watch_features.data.repository.DataStoreRepositoryImp
import com.example.watch.watch_features.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(app: Application): DataStoreRepository{
        return DataStoreRepositoryImp(app)
    }

}