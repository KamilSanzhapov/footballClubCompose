package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.repos.AreaRepository

class GetAreaByIdUseCase(private val areaRepository: AreaRepository) {

    suspend fun execute(id: String): AreaModel {
        return areaRepository.getAreaById(id)
    }
}