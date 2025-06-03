package com.example.treblewinner.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TrebleWinnerRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.fetchAndCacheData()
        }
    }
}
