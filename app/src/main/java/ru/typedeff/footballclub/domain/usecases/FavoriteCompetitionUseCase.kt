package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.repos.FavoriteRepository

class FavoriteCompetitionUseCase(private val favoriteRepository: FavoriteRepository) {


    suspend fun getAll(): List<CompetitionModel> {
        return favoriteRepository.getAllFavoriteCompetitions()
    }

    suspend fun get(id: String): Boolean {
        return favoriteRepository.isFavoriteCompetition(id)
    }


    suspend fun set(competition: CompetitionModel, isFavorite: Boolean) {
        favoriteRepository.isFavoriteCompetition(competition, isFavorite)
    }
}