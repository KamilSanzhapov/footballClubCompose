package ru.typedeff.footballclub.data.converter

import ru.typedeff.footballclub.data.api.api_models.ListMatchesData
import ru.typedeff.footballclub.data.api.api_models.MatchTeamData
import ru.typedeff.footballclub.data.api.api_models.ScorePeriodData
import ru.typedeff.footballclub.domain.models.ListMatchesModel
import ru.typedeff.footballclub.domain.models.MatchShortModel
import ru.typedeff.footballclub.domain.models.MatchStatus
import ru.typedeff.footballclub.domain.models.MatchTeamShortModel
import ru.typedeff.footballclub.domain.models.ScorePeriodShortModel
import ru.typedeff.footballclub.utils.dateFormateFromApi
import ru.typedeff.footballclub.utils.dateFormateToDisplay
import java.time.LocalDate

fun ScorePeriodData.toModel() = ScorePeriodShortModel(
    home ?: 0, away ?: 0
)

fun MatchTeamData.toModel() = MatchTeamShortModel(
    id = id ?: 0,
    name = name ?: "",
    shortName = shortName ?: "",
    tla = tla ?: "",
    crest = crest ?: ""

)

fun ListMatchesData.toModel(): ListMatchesModel {
    val resultList = matches.map { matchData ->
        MatchShortModel(
            id = matchData.id ?: -1,
            status = MatchStatus.from(matchData.status ?: ""),
            scoreFullTime = matchData.score?.fullTime?.toModel() ?: ScorePeriodShortModel(0, 0),
            scoreHalfTime = matchData.score?.halfTime?.toModel() ?: ScorePeriodShortModel(0, 0),
            homeTeam = matchData.homeTeam?.toModel(),
            awayTeam = matchData.awayTeam?.toModel(),
            utcDate = matchData.utcDate ?: "",
            dateString = ""
        )
    }

    val matchesGroup = resultList.groupBy { match ->
        val date = LocalDate.parse(match.utcDate, dateFormateFromApi)
        match.dateString = dateFormateToDisplay.format(date)
        return@groupBy date
    }

    return ListMatchesModel(matchesGroup)
}