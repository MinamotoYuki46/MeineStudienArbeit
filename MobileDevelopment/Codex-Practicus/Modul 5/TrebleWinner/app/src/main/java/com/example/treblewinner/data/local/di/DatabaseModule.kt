package com.example.treblewinner.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.treblewinner.data.local.dao.TrebleWinnerDao
import com.example.treblewinner.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "treble_winner_db"
        ).build()
    }

    @Provides
    fun provideTrebleWinnerDao(appDatabase: AppDatabase): TrebleWinnerDao {
        return appDatabase.trebleWinnerDao()
    }
}
