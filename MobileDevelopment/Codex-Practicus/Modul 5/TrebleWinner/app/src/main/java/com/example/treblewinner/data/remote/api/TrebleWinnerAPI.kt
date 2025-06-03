package com.example.treblewinner.data.remote.api

import retrofit2.http.GET
import com.example.treblewinner.data.remote.response.ClubResponse
import com.example.treblewinner.data.remote.response.CompetitionResponse
import retrofit2.http.Path

interface TrebleWinnerAPI {
    @GET("/clubs")
    suspend fun getClubs(): List<ClubResponse>

    @GET("/competitions")
    suspend fun getCompetitions(): List<CompetitionResponse>

    @GET("/clubs/{id}")
    suspend fun getClubDetail(@Path("id") clubId: String): ClubResponse

    @GET("/competitions/{id}")
    suspend fun getCompetitionDetail(@Path("id") competitionId: String): CompetitionResponse
}