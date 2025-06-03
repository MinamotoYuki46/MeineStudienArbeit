package com.example.treblewinner.domain.usecase

import com.example.treblewinner.domain.model.Competition
import com.example.treblewinner.domain.repository.TrebleWinnerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCompetitionsUseCase @Inject constructor (private val repository: TrebleWinnerRepository) {
    operator fun invoke(): Flow<List<Competition>> = repository.getAllCompetitions()
}