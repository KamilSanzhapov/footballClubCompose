package ru.typedeff.footballclub.utils

const val API_ENDPOINT = "https://api.football-data.org/v4/"


// Т.к тарифный план football-data.org ограничивает список лиг,
// то отображаем только страны c доступынми туринирами
const val EUROPE_AREA_ID = "2077"
const val ENGLAND_AREA_ID = "2072"
const val SPAIN_AREA_ID = "2224"
const val PORTUGAL_AREA_ID = "2187"
const val GERMAN_AREA_ID = "2088"

val availableAreas =
    listOf(EUROPE_AREA_ID, ENGLAND_AREA_ID, SPAIN_AREA_ID, PORTUGAL_AREA_ID, GERMAN_AREA_ID)

