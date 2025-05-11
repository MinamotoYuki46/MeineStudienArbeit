package com.example.treblewinner.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treblewinner.constants.ClubConstant
import com.example.treblewinner.model.Club
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubViewModel: ViewModel() {
    private val _clubs = MutableStateFlow<List<Club>>(emptyList())
    val clubs: StateFlow<List<Club>> get() = _clubs.asStateFlow()

    var selectedClub by mutableStateOf<Club?>(null)
        private set

    fun selectClub(club: Club){
        selectedClub = club
    }

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _clubs.value = ClubConstant.ALL
        }
    }
}