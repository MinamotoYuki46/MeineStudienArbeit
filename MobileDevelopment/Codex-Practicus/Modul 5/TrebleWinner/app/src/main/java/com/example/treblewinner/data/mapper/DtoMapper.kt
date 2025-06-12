package com.example.treblewinner.data.mapper

import com.example.treblewinner.data.local.entity.ClubEntity
import com.example.treblewinner.data.local.entity.CompetitionEntity
import com.example.treblewinner.data.remote.dto.ClubDto
import com.example.treblewinner.data.remote.dto.CompetitionDto

import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.model.Competition
import com.example.treblewinner.data.local.relation.ClubWithCompetitions

object DtoMapper {
    fun toClubEntity(dto: ClubDto): ClubEntity {
        return ClubEntity(
            id = dto.id,
            name = dto.name,
            country = dto.country,
            confederation = dto.confederation,
            trebleYears = dto.trebleYears,
            competitionIds = dto.competitionIds,
            logoUrl = dto.logoUrl,
            webUrl = dto.webUrl,
            description = dto.description,
            isBookmarked = false
        )
    }

    fun toCompetitionEntity(dto: CompetitionDto): CompetitionEntity {
        return CompetitionEntity(
            id = dto.id,
            name = dto.name,
            country = dto.country,
            confederation = dto.confederation,
            logoUrl = dto.logoUrl,
            logoUrlDark = dto.logoUrlDark
        )
    }

    fun toClubEntityList(dtos: List<ClubDto>): List<ClubEntity> {
        return dtos.map { toClubEntity(it) }
    }

    fun toCompetitionEntityList(dtos: List<CompetitionDto>): List<CompetitionEntity> {
        return dtos.map { toCompetitionEntity(it) }
    }

    fun mapClubEntityToDomain(entity: ClubEntity): Club {
        return Club(
            id = entity.id,
            name = entity.name,
            country = entity.country,
            confederation = entity.confederation,
            trebleYears = entity.trebleYears,
            competitionIds = entity.competitionIds,
            logoUrl = entity.logoUrl,
            webUrl = entity.webUrl,
            description = entity.description,
            isBookmarked = entity.isBookmarked
        )
    }

    fun mapCompetitionEntityToDomain(entity: CompetitionEntity): Competition {
        return Competition(
            id = entity.id,
            name = entity.name,
            country = entity.country,
            confederation = entity.confederation,
            logoUrl = entity.logoUrl,
            logoUrlDark = entity.logoUrlDark
        )
    }

    fun mapClubWithCompetitionsToDomain(data: ClubWithCompetitions): Club {
        return Club(
            id = data.club.id,
            name = data.club.name,
            country = data.club.country,
            confederation = data.club.confederation,
            trebleYears = data.club.trebleYears,
            competitionIds = data.club.competitionIds,
            logoUrl = data.club.logoUrl,
            webUrl = data.club.webUrl,
            description = data.club.description,
            isBookmarked = data.club.isBookmarked
        )
    }
}