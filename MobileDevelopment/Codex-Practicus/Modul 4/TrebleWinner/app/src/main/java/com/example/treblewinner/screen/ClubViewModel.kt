package com.example.treblewinner.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treblewinner.model.Club
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubViewModel(private val clubList: List<Club>) : ViewModel() {
    private val _clubs = MutableStateFlow<List<Club>>(emptyList())
    val clubs: StateFlow<List<Club>> get() = _clubs.asStateFlow()

    var selectedClub by mutableStateOf<Club?>(null)
        private set

    fun selectClub(club: Club){
        selectedClub = club
        Log.i("ClubVM", "Successfully load ${selectedClub?.name} data")
    }

    private var hasLoaded = false

    fun loadData() {
        if (!hasLoaded) {
            Log.i("ClubVM", "First load data")
            viewModelScope.launch {
                _clubs.value = clubList
                hasLoaded = true
            }
        }
        else {
            Log.i("ClubVM", "Data already loaded!")
        }
    }
}
