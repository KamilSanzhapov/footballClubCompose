package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class CompetitionRepositoryImpl(private val api: ApiService) : CompetitionRepository {
    override suspend fun getCompetitionsByAreaId(id: String): ListCompetitionModel {

//        api.getCompetitionStandingsById("2021")
//        api.getCompetitionMatchesById("2021")
//        api.getCompetitionTopScorersById("2021")

        return api.getCompetitionsByAreaId(id).toModel()
    }

}
