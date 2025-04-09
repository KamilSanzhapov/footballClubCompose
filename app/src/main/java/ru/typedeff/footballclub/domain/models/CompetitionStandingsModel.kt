package ru.typedeff.footballclub.domain.models


data class CompetitionStandingsModel(
    val competition: CompetitionShortModel? = null,
    val tables: List<TableModel> = listOf()
)

data class TableModel(
    val position: Int? = null,
    val team: TeamModel? = null,
    val playedGames: Int? = null,
    val form: String? = null,
    val won: Int? = null,
    val draw: Int? = null,
    val lost: Int? = null,
    val points: Int? = null,
    val goalsFor: Int? = null,
    val goalsAgainst: Int? = null,
    val goalDifference: Int? = null
)


data class TeamModel(
    val id: Int? = null,
    val name: String? = null,
    val shortName: String? = null,
    val tla: String? = null,
    val crest: String? = null
)
