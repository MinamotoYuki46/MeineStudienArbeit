package com.example.treblewinner.presentation.bookmark

import android.util.Log
import com.example.treblewinner.domain.usecase.GetBookmarkedClubsUseCase
import com.example.treblewinner.domain.usecase.ToggleClubBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update

@HiltViewModel
class BookmarkedClubsViewModel @Inject constructor(
    private val getBookmarkedClubsUseCase: GetBookmarkedClubsUseCase,
    private val toggleClubBookmarkUseCase: ToggleClubBookmarkUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(BookmarkedClubsUIState())
    val uiState: StateFlow<BookmarkedClubsUIState> = _uiState

    private var hasLoaded = false

    fun toggleBookmark(clubId: String) {
        viewModelScope.launch {
            toggleClubBookmarkUseCase(clubId)
            val updatedClubs = _uiState.value.bookmarkedClubs.map { club ->
                if (club.id == clubId) club.copy(isBookmarked = !club.isBookmarked)
                else club
            }
            _uiState.update { it.copy(bookmarkedClubs = updatedClubs) }
        }
        loadData(forceReload = true)
    }

    fun loadData(forceReload: Boolean = false) {
        if (!hasLoaded || forceReload) {
            hasLoaded = true
            viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true, error = null) }
                getBookmarkedClubsUseCase()
                    .catch { e ->
                        Log.e("Bookmark VM", "Error loading bookmarked clubs", e)
                        _uiState.update { it.copy(isLoading = false, error = e.message ?: "Unknown error") }
                    }
                    .collect { clubs ->
                        _uiState.update { it.copy(isLoading = false, bookmarkedClubs = clubs, error = null) }
                    }
            }
        } else {
            Log.i("Bookmark VM", "Data already loaded")
        }
    }
}