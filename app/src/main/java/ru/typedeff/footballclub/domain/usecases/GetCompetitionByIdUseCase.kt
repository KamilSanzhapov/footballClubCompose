package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class GetCompetitionByIdUseCase(private val competitionRepository: CompetitionRepository) {

     suspend fun execute(id:String): ListCompetitionModel {
        return competitionRepository.getCompetitionsByAreaId(id)
    }
}