package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.repos.AreaRepository

class AreaRepositoryImpl(private val api: ApiService) : AreaRepository {
    override suspend fun getAreasFromFilter(filter: String): ListAreaModel {
        return api.getAreasByFilters(filter).toModel()
    }

    override suspend fun getAreaById(id: String): AreaModel {
        return api.getAreaById(id).toModel()
    }
}



