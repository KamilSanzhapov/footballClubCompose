package ru.typedeff.footballclub.domain.models

data class ListCompetitionModel(
    val competitions: List<CompetitionModel> = arrayListOf()
)

data class CompetitionModel(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
    val plan: String,
    val isFavorite: Boolean
)