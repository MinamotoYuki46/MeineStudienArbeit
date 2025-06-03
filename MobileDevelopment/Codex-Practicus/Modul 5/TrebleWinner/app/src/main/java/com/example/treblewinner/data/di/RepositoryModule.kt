package com.example.treblewinner.data.di

import com.example.treblewinner.data.repository.TrebleWinnerRepositoryImpl
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTrebleWinnerRepository(
        impl: TrebleWinnerRepositoryImpl
    ): TrebleWinnerRepository
}