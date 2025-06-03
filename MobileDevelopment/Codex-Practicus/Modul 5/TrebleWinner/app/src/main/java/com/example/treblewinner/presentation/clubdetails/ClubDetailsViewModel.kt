package com.example.treblewinner.presentation.clubdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treblewinner.domain.usecase.GetAllCompetitionsUseCase
import com.example.treblewinner.domain.usecase.GetClubDetailUseCase
import com.example.treblewinner.domain.usecase.ToggleClubBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubDetailsViewModel @Inject constructor(
    private val getClubDetailUseCase: GetClubDetailUseCase,
    private val toggleClubBookmarkUseCase: ToggleClubBookmarkUseCase,
    private val getAllCompetitionsUseCase: GetAllCompetitionsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ClubDetailsUIState())
    val uiState: StateFlow<ClubDetailsUIState> = _uiState

    fun loadClubDetail(clubId: String) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                val club = getClubDetailUseCase(clubId)
                val allCompetitions = getAllCompetitionsUseCase().first()
                val filteredCompetitions = allCompetitions.filter { competition ->
                    competition.id in (club?.competitionIds ?: emptyList())
                }

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        club = club,
                        competitions = filteredCompetitions,
                        error = null
                    )
                }

            } catch (e: Exception) {
                Log.e("ClubDetailViewModel", "Error loading club detail", e)
                _uiState.update {
                    it.copy(isLoading = false, error = e.message ?: "Unknown error")
                }
            }
        }
    }

    fun toggleBookmark() {
        val currentClub = _uiState.value.club ?: return
        viewModelScope.launch {
            toggleClubBookmarkUseCase(currentClub.id)
            _uiState.update {
                it.copy(club = currentClub.copy(isBookmarked = !currentClub.isBookmarked))
            }
        }
    }
}