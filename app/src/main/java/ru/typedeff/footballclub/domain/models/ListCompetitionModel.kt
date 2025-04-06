package ru.typedeff.footballclub.domain.models

data class ListCompetitionModel(
    var competitions: List<CompetitionModel> = arrayListOf()
)

data class CompetitionModel(
    var id: Int,
    var name: String,
    var code: String,
    var type: String,
    var emblem: String,
    var plan: String
)
