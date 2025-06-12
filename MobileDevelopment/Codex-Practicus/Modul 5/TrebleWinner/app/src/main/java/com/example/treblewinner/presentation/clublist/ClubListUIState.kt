package com.example.treblewinner.presentation.clublist

import com.example.treblewinner.domain.model.Club

data class ClubListUIState(
    val isLoading: Boolean = false,
    val clubs: List<Club> = emptyList(),
    val error: String? = null
)