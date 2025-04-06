package ru.typedeff.footballclub.domain.repos

import ru.typedeff.footballclub.domain.models.ListCompetitionModel

interface CompetitionRepository {
    suspend fun getCompetitionsByAreaId(id: String): ListCompetitionModel
}
