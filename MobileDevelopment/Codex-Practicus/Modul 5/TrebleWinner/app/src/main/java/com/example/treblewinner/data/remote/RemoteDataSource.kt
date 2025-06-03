package com.example.treblewinner.data.remote

import android.util.Log
import com.example.treblewinner.data.remote.api.TrebleWinnerAPI
import com.example.treblewinner.data.remote.dto.ClubDto
import com.example.treblewinner.data.remote.dto.CompetitionDto
import com.example.treblewinner.data.remote.mapper.ResponseMapper
import com.example.treblewinner.data.remote.response.ClubResponse
import com.example.treblewinner.data.remote.response.CompetitionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: TrebleWinnerAPI
) {
    fun getClubs(): Flow<List<ClubDto>> = flow {
        try {
            val response: List<ClubResponse> = api.getClubs()
            val clubsDto: List<ClubDto> = response.map { ResponseMapper.toClubDto(it) }

            Log.d("RemoteDataSource", "API getClubs response size: ${response.size}")
            Log.d("RemoteDataSource", "API getClubs response: $response")

            Log.d("RemoteDataSource", "Mapped clubsDto size: ${clubsDto.size}")

            emit(clubsDto)
        } catch (e: IOException){
            e.printStackTrace()
            emit(emptyList())
        } catch (e: HttpException){
            e.printStackTrace()
            emit(emptyList())
        }
    }

    fun getCompetitions(): Flow<List<CompetitionDto>> = flow {
        try {
            val response: List<CompetitionResponse> = api.getCompetitions()
            val competitionsDto: List<CompetitionDto> = response.map { ResponseMapper.toCompetitionDto(it) }

            emit(competitionsDto)
        } catch (e: IOException){
            e.printStackTrace()
            emit(emptyList())
        } catch (e: HttpException){
            e.printStackTrace()
            emit(emptyList())
        }
    }
}