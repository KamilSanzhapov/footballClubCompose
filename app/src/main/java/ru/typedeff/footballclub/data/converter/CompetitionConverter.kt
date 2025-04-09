package ru.typedeff.footballclub.data.converter

import ru.typedeff.footballclub.data.api.api_models.CompetitionStandingsData
import ru.typedeff.footballclub.data.api.api_models.ListCompetitionData
import ru.typedeff.footballclub.data.api.api_models.TableData
import ru.typedeff.footballclub.data.api.api_models.TeamData
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.models.CompetitionShortModel
import ru.typedeff.footballclub.domain.models.CompetitionStandingsModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.models.TableModel
import ru.typedeff.footballclub.domain.models.TeamModel


// Фильтр для списка турнирных таблиц
//
const val StandingType = "TOTAL"

fun ListCompetitionData.toModel(): ListCompetitionModel {

    val competitions = competitions.map {
        CompetitionModel(
            it.id ?: -1, it.name ?: "", it.code ?: "", it.type ?: "", it.emblem ?: "", it.plan ?: ""
        )
    }
    return ListCompetitionModel(competitions)
}

fun TeamData.toModel(): TeamModel {
    return TeamModel(
        id = id, name = name, shortName = shortName, tla = tla, crest = crest
    )
}


fun TableData.toModel(): TableModel {


    return TableModel(
        position = position,
        team = team?.toModel(),
        playedGames = playedGames,
        form = form,
        won = won,
        draw = draw,
        lost = lost,
        points = points,
        goalsFor = goalsFor,
        goalsAgainst = goalsAgainst,
        goalDifference = goalDifference
    )
}

fun CompetitionStandingsData.toModel(): CompetitionStandingsModel {

    val competition: CompetitionShortModel? = competition?.let { competition ->
        CompetitionShortModel(
            competition.id, competition.name, competition.code, competition.type, competition.emblem
        )
    }

    val tableData = standings.firstOrNull { standingsData ->
        standingsData.type == StandingType

    }?.table ?: arrayListOf()

    val tableModel = tableData.map {
        it.toModel()
    }
    return CompetitionStandingsModel(
        competition = competition, tables = tableModel
    )

}
