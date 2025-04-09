package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.CompetitionStandingsModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class GetStandingsCompetitionByIdUseCase(private val competitionRepository: CompetitionRepository) {

     suspend fun execute(id:String): CompetitionStandingsModel {
        return competitionRepository.getStandingsById(id)
    }
}