package com.example.treblewinner.data.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.treblewinner.data.local.entity.ClubCompetitionCrossRef
import com.example.treblewinner.data.local.entity.ClubEntity
import com.example.treblewinner.data.local.entity.CompetitionEntity

class ClubWithCompetitions(
    @Embedded val club: ClubEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = ClubCompetitionCrossRef::class,
            parentColumn = "clubId",
            entityColumn = "competitionId"
        )
    )
    val competitions: List<CompetitionEntity>
)