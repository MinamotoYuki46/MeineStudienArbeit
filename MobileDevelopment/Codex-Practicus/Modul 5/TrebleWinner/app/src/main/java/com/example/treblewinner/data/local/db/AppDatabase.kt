package com.example.treblewinner.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.treblewinner.data.local.converters.Converters
import com.example.treblewinner.data.local.dao.TrebleWinnerDao
import com.example.treblewinner.data.local.entity.ClubEntity
import com.example.treblewinner.data.local.entity.CompetitionEntity
import com.example.treblewinner.data.local.entity.ClubCompetitionCrossRef

@Database(
    entities = [
        ClubEntity::class,
        CompetitionEntity::class,
        ClubCompetitionCrossRef::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trebleWinnerDao(): TrebleWinnerDao
}
