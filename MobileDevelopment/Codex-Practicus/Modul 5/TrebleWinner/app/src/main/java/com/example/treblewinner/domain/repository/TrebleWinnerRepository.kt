package com.example.treblewinner.domain.repository

import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.model.Competition
import kotlinx.coroutines.flow.Flow

interface TrebleWinnerRepository {
    fun getAllClubs(): Flow<List<Club>>
    suspend fun getClubDetail(id: String): Club?
    fun getBookmarkedClubs(): Flow<List<Club>>
    suspend fun toggleClubBookmark(id: String)
    suspend fun fetchAndCacheData()
    fun getAllCompetitions(): Flow<List<Competition>>
}