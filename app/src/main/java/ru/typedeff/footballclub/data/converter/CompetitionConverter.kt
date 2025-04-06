package ru.typedeff.footballclub.data.converter

import ru.typedeff.footballclub.data.api.api_models.ListCompetitionData
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel


fun ListCompetitionData.toModel(): ListCompetitionModel {

    val competitions = competitions.map {
        CompetitionModel(
            it.id ?: -1,
            it.name ?: "",
            it.code ?: "",
            it.type ?: "",
            it.emblem ?: "",
            it.plan ?: ""
        )
    }
    return ListCompetitionModel(competitions)
}
