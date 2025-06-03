package com.example.treblewinner.domain.model

data class Club(
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,
    val trebleYears: List<String>,
    val competitionIds: List<String>,
    val logoUrl: String,
    val webUrl: String,
    val description: String,
    val isBookmarked: Boolean
)
