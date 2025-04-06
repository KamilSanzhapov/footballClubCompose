package ru.typedeff.footballclub.domain.models


data class ListAreaModel(
    val areas: List<AreaModel> = listOf()
)

data class AreaModel(
    val id: Int, val name: String, val flag: String
)
