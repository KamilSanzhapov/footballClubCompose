package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.domain.models.CompetitionStandingsModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class CompetitionRepositoryImpl(private val api: ApiService) : CompetitionRepository {
    override suspend fun getCompetitionsByAreaId(id: String): ListCompetitionModel {
        return api.getCompetitionsByAreaId(id).toModel()
    }

    override suspend fun getStandingsById(id: String): CompetitionStandingsModel {
        return api.getCompetitionStandingsById(id).toModel()
    }


}
