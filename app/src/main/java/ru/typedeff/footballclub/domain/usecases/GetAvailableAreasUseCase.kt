package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.repos.AreaRepository
import ru.typedeff.footballclub.utils.availableAreas

class GetAvailableAreasUseCase(private val areaRepository: AreaRepository) {

    suspend fun execute(): ListAreaModel {
        return areaRepository.getAreasFromFilter(availableAreas.joinToString(","))
    }
}