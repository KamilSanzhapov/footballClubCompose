package ru.typedeff.footballclub.domain.repos

import ru.typedeff.footballclub.domain.models.CompetitionModel

interface FavoriteRepository {
    suspend fun getAllFavoriteCompetitions(): List<CompetitionModel>
    suspend fun isFavoriteCompetition(competition: CompetitionModel, isFavorite: Boolean)
    suspend fun isFavoriteCompetition(competitionId: String): Boolean
}