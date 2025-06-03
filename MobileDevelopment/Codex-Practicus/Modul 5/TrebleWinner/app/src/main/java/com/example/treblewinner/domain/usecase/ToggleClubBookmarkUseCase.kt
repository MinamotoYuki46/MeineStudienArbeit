package com.example.treblewinner.domain.usecase

import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import javax.inject.Inject

class ToggleClubBookmarkUseCase @Inject constructor(private val repository: TrebleWinnerRepository) {
    suspend operator fun invoke(id: String) = repository.toggleClubBookmark(id)
}
