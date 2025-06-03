package com.example.treblewinner.presentation.clubdetails

import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.model.Competition

data class ClubDetailsUIState(
    val isLoading: Boolean = true,
    val club: Club? = null,
    val competitions: List<Competition> = emptyList(),
    val error: String? = null
)
