package ru.typedeff.footballclub.domain.models

import java.time.LocalDate


/*
* Возможные статусы игры
* */
enum class MatchStatus(val str: String) {
    // Игра запланирована
    SCHEDULED("SCHEDULED"),

    // Определено время игры
    TIMED("TIMED"),

    // Игра идет
    IN_PLAY("IN_PLAY"),

    // Перерыв
    PAUSED("PAUSED"),

    // Игра завершена
    FINISHED("FINISHED"),

    //Игра приостоновлена
    SUSPENDED("SUSPENDED"),

    //Игра отложена
    POSTPONED("POSTPONED"),

    //Игра отменена
    CANCELLED("CANCELLED"),

    //Идет награждение
    AWARDED("AWARDED");

    companion object {
        infix fun from(value: String): MatchStatus =
            MatchStatus.entries.firstOrNull { it.name == value } ?: CANCELLED
    }
}


data class ListMatchesModel(
    val groupByDateMatches: Map<LocalDate, List<MatchShortModel>> = emptyMap()
)

data class MatchShortModel(
    val id: Int,
    val status: MatchStatus,
    val scoreFullTime: ScorePeriodShortModel,
    val scoreHalfTime: ScorePeriodShortModel,
    val homeTeam: MatchTeamShortModel?,
    val awayTeam: MatchTeamShortModel?,
    val utcDate: String,
    var dateString: String,

)


data class ScorePeriodShortModel(
    val home: Int, val away: Int
)

data class MatchTeamShortModel(
    val id: Int, val name: String, val shortName: String, val tla: String, val crest: String
)
