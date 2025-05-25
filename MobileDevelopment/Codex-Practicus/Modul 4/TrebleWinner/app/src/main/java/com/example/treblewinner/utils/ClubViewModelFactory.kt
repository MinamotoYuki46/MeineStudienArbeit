package com.example.treblewinner.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.treblewinner.model.Club
import com.example.treblewinner.screen.ClubViewModel

class ClubViewModelFactory(
    private val clubList: List<Club>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClubViewModel::class.java)){
            return ClubViewModel(clubList) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}