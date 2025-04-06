package ru.typedeff.footballclub.domain.repos

import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.models.ListAreaModel

interface AreaRepository {
    suspend fun getAreasFromFilter(filter: String): ListAreaModel
    suspend fun getAreaById(id: String): AreaModel
}
