package com.example.treblewinner.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.RoomDatabase
import com.example.treblewinner.data.local.dao.TrebleWinnerDao

@Entity(
    tableName = "club_competition_cross_ref",
    primaryKeys = ["clubId", "competitionId"],
    foreignKeys = [
        ForeignKey(entity = ClubEntity::class, parentColumns = ["id"], childColumns = ["clubId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = CompetitionEntity::class, parentColumns = ["id"], childColumns = ["competitionId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("clubId"), Index("competitionId")]
)

data class ClubCompetitionCrossRef(
    val clubId: String,
    val competitionId: String
)

abstract class TrebleWinnerDatabase : RoomDatabase() {
    abstract fun trebleWinnerDao(): TrebleWinnerDao
}