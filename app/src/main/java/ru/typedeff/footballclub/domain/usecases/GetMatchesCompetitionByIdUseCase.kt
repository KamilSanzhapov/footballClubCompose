package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.ListMatchesModel
import ru.typedeff.footballclub.domain.repos.CompetitionRepository

class GetMatchesCompetitionByIdUseCase(private val competitionRepository: CompetitionRepository) {

     suspend fun execute(id:String): ListMatchesModel {
        return competitionRepository.getCompetitionMatchesById(id)
    }
}