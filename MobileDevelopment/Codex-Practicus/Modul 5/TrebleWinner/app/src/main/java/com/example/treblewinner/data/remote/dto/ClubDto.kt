package com.example.treblewinner.data.remote.dto

data class ClubDto(
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,
    val trebleYears: List<String>,
    val competitionIds: List<String>,
    val logoUrl: String,
    val webUrl: String,
    val description: String
)