package com.example.treblewinner.domain.usecase

import com.example.treblewinner.domain.model.Club
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import javax.inject.Inject

class GetClubDetailUseCase @Inject constructor(private val repository: TrebleWinnerRepository) {
    suspend operator fun invoke(id: String): Club? = repository.getClubDetail(id)
}
