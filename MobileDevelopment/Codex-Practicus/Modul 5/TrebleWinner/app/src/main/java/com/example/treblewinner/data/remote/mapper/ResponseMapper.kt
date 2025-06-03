package com.example.treblewinner.data.remote.mapper

import com.example.treblewinner.data.remote.dto.ClubDto
import com.example.treblewinner.data.remote.dto.CompetitionDto
import com.example.treblewinner.data.remote.response.ClubResponse
import com.example.treblewinner.data.remote.response.CompetitionResponse

object ResponseMapper {
    fun toClubDto(response: ClubResponse): ClubDto {
        return ClubDto (
            id = response.id,
            name = response.name,
            country = response.country,
            confederation = response.confederation,
            trebleYears = response.trebleYears,
            competitionIds = response.competitionIds,
            logoUrl = response.logoUrl,
            webUrl = response.webUrl,
            description = response.description
        )
    }

    fun toCompetitionDto(response: CompetitionResponse): CompetitionDto {
        return CompetitionDto (
            id = response.id,
            name = response.name,
            country = response.country,
            confederation = response.confederation,
            logoUrl = response.logoUrl,
            logoUrlDark = response.logoUrlDark
        )
    }
}