package com.example.treblewinner.presentation.clublist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treblewinner.domain.usecase.FetchAndCacheDataUseCase
import com.example.treblewinner.domain.usecase.GetAllClubsUseCase
import com.example.treblewinner.domain.usecase.ToggleClubBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubListViewModel @Inject constructor(
    private val getAllClubsUseCase: GetAllClubsUseCase,
    private val toggleClubBookmarkUseCase: ToggleClubBookmarkUseCase,
    private val fetchAndCacheDataUseCase: FetchAndCacheDataUseCase
) : ViewModel(){

    private val _uiState = MutableStateFlow(ClubListUIState())
    val uiState: StateFlow<ClubListUIState> = _uiState.asStateFlow()

    fun toggleBookmark(clubId: String) {
        viewModelScope.launch {
            toggleClubBookmarkUseCase(clubId)
            val updatedClubs = _uiState.value.clubs.map { club ->
                if (club.id == clubId) club.copy(isBookmarked = !club.isBookmarked)
                else club
            }
            _uiState.update { it.copy(clubs = updatedClubs) }
        }
    }


    private var hasLoaded = false

    fun loadData() {
        if (!hasLoaded) {
            Log.i("ClubVM", "First load data")
            viewModelScope.launch {
                try {
                    fetchAndCacheDataUseCase()
                    getAllClubsUseCase()
                        .catch { e ->
                            Log.e("ClubVM", "Error loading clubs", e)
                        }
                        .collect { result ->
                            Log.i("ClubVM", "Received clubs: ${result.size}")
                            _uiState.value = ClubListUIState(
                                isLoading = false,
                                clubs = result,
                                error = null
                            )
                            hasLoaded = true
                        }
                } catch (e: Exception) {
                    Log.e("ClubVM", "Unexpected error", e)
                    _uiState.value = ClubListUIState(
                        isLoading = false,
                        clubs = emptyList(),
                        error = e.message ?: "Unknown error"
                    )
                }
            }
        }
        else {
            Log.i("ClubVM", "Data already loaded!")
        }
    }
}