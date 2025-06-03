package com.example.treblewinner.data.remote.dto

data class CompetitionDto(
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,
    val logoUrl: String,
    val logoUrlDark: String
)