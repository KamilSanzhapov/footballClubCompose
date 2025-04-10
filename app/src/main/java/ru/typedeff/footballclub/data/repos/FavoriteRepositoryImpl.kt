package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.converter.toEntity
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.data.db.AppDataBase
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.repos.FavoriteRepository

class FavoriteRepositoryImpl(private val db: AppDataBase) : FavoriteRepository {

    override suspend fun getAllFavoriteCompetitions(): List<CompetitionModel> {
        return db.getFavoriteDao().getAll().map { it.toModel() }
    }

    override suspend fun isFavoriteCompetition(
        competition: CompetitionModel, isFavorite: Boolean
    ) {
        val favoriteEntity = competition.toEntity()
        if (isFavorite) db.getFavoriteDao().insert(favoriteEntity)
        else db.getFavoriteDao().delete(favoriteEntity)
    }

    override suspend fun isFavoriteCompetition(competitionId: String): Boolean {
        return db.getFavoriteDao().getById(competitionId).isNotEmpty()
    }
}