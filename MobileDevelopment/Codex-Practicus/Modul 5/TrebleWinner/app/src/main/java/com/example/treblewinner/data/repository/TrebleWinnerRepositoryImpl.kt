package com.example.treblewinner.data.repository

import com.example.treblewinner.data.local.dao.TrebleWinnerDao
import com.example.treblewinner.data.local.relation.ClubWithCompetitions
import com.example.treblewinner.data.mapper.DtoMapper
import com.example.treblewinner.data.remote.RemoteDataSource
import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.model.Competition
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrebleWinnerRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val trebleWinnerDao: TrebleWinnerDao
): TrebleWinnerRepository {
    override fun getAllClubs(): Flow<List<Club>> {
        return trebleWinnerDao.getAllClubs()
            .map { clubEntities ->
                clubEntities.map { DtoMapper.mapClubEntityToDomain(it) }
            }
    }

    override suspend fun getClubDetail(id: String): Club? {
        val clubWithCompetitions: ClubWithCompetitions? = trebleWinnerDao.getClubWithCompetitions(id)
        return clubWithCompetitions?.let { DtoMapper.mapClubWithCompetitionsToDomain(it) }
    }

    override fun getBookmarkedClubs(): Flow<List<Club>> {
        return trebleWinnerDao.getBookmarkedClubs()
            .map { bookmarkedEntities ->
                bookmarkedEntities.map { DtoMapper.mapClubEntityToDomain(it) }
            }
    }

    override suspend fun toggleClubBookmark(id: String) {
        trebleWinnerDao.toggleClubBookmark(id)
    }


    override suspend fun fetchAndCacheData() {
        remoteDataSource.getClubs().collect { clubDtos ->
            val clubEntities = DtoMapper.toClubEntityList(clubDtos)
            trebleWinnerDao.insertClubs(clubEntities)
        }
        remoteDataSource.getCompetitions().collect { competitionDtos ->
            val competitionEntities = DtoMapper.toCompetitionEntityList(competitionDtos)
            trebleWinnerDao.insertCompetitions(competitionEntities)
        }
    }


    override fun getAllCompetitions(): Flow<List<Competition>> {
        return trebleWinnerDao.getAllCompetitions()
            .map { competitionEntities ->
                competitionEntities.map { DtoMapper.mapCompetitionEntityToDomain(it) }
            }
    }

}