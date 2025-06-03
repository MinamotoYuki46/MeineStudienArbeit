package com.example.treblewinner.presentation.bookmark

import com.example.treblewinner.domain.model.Club

data class BookmarkedClubsUIState(
    val bookmarkedClubs: List<Club> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)