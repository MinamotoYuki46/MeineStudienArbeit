package com.example.treblewinner.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.treblewinner.data.local.entity.ClubEntity
import com.example.treblewinner.data.local.entity.CompetitionEntity
import com.example.treblewinner.data.local.relation.ClubWithCompetitions
import kotlinx.coroutines.flow.Flow

@Dao
interface TrebleWinnerDao {
    @Query("SELECT * FROM clubs ORDER BY confederation ASC")
    fun getAllClubs(): Flow<List<ClubEntity>>

    @Query("SELECT * FROM competitions ORDER BY confederation ASC")
    fun getAllCompetitions(): Flow<List<CompetitionEntity>>

    @Transaction
    @Query("SELECT * FROM clubs WHERE id = :clubId")
    suspend fun getClubWithCompetitions(clubId: String): ClubWithCompetitions?

    @Insert(onConflict = IGNORE)
    suspend fun insertClubs(clubs: List<ClubEntity>)

    @Insert(onConflict = IGNORE)
    suspend fun insertCompetitions(competitions: List<CompetitionEntity>)

    @Update
    suspend fun updateClub(club: ClubEntity)


    @Query("SELECT * FROM clubs WHERE is_bookmarked = 1")
    fun getBookmarkedClubs(): Flow<List<ClubEntity>>

    @Query("DELETE FROM clubs WHERE is_bookmarked = 0")
    suspend fun deleteAllNonBookmarked()

    @Query("SELECT EXISTS(SELECT * FROM clubs WHERE id = :clubId AND is_bookmarked = 1)")
    suspend fun isClubsBookmarked(clubId: String): Boolean

    @Query("UPDATE clubs SET is_bookmarked = NOT is_bookmarked WHERE id = :clubId")
    suspend fun toggleClubBookmark(clubId: String)
}