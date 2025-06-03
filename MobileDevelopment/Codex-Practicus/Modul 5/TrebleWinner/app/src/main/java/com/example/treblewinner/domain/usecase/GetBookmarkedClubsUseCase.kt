package com.example.treblewinner.domain.usecase

import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkedClubsUseCase @Inject constructor(private val repository: TrebleWinnerRepository) {
    operator fun invoke(): Flow<List<Club>> = repository.getBookmarkedClubs()
}
