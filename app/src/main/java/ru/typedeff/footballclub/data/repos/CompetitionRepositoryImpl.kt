package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.data.db.AppDataBase
import ru.typedeff.footballclub.domain.models.CompetitionStandingsModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.models.ListMatchesModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class CompetitionRepositoryImpl(private val api: ApiService, private val dataBase: AppDataBase) : CompetitionRepository {

    override suspend fun getCompetitionsByAreaId(id: String): ListCompetitionModel {
        val allFavoriteCompetitions = dataBase.getFavoriteDao().getAllIds()
        return api.getCompetitionsByAreaId(id).toModel(allFavoriteCompetitions)
    }

    override suspend fun getStandingsById(id: String): CompetitionStandingsModel {
        val favoriteCompetition = dataBase.getFavoriteDao().getById(id).isNotEmpty()
        return api.getCompetitionStandingsById(id).toModel(favoriteCompetition)
    }

    override suspend fun getCompetitionMatchesById(id: String): ListMatchesModel {
        return api.getCompetitionMatchesById(id).toModel()
    }
}
