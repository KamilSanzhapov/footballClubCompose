package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.typedeff.footballclub.R
import ru.typedeff.footballclub.domain.models.MatchShortModel
import ru.typedeff.footballclub.domain.models.MatchStatus.AWARDED
import ru.typedeff.footballclub.domain.models.MatchStatus.CANCELLED
import ru.typedeff.footballclub.domain.models.MatchStatus.FINISHED
import ru.typedeff.footballclub.domain.models.MatchStatus.IN_PLAY
import ru.typedeff.footballclub.domain.models.MatchStatus.PAUSED
import ru.typedeff.footballclub.domain.models.MatchStatus.POSTPONED
import ru.typedeff.footballclub.domain.models.MatchStatus.SCHEDULED
import ru.typedeff.footballclub.domain.models.MatchStatus.SUSPENDED
import ru.typedeff.footballclub.domain.models.MatchStatus.TIMED
import ru.typedeff.footballclub.ui.theme.GREEN_LIVE
import ru.typedeff.footballclub.ui.theme.RED_ERROR
import ru.typedeff.footballclub.utils.toTimeFormat


@Composable
fun MatchItem(matchShortModel: MatchShortModel, onClick: () -> Unit) {
    ListCard {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(42.dp)
                .fillMaxWidth()
                .clickable(onClick = onClick),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.weight(0.42f), horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextNormal(
                    matchShortModel.homeTeam?.shortName.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                SVGImage(matchShortModel.homeTeam?.crest.toString())
            }
            Column(
                modifier = Modifier.weight(0.16f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                ScoreMatch(matchShortModel)
            }

            Row(
                modifier = Modifier.weight(0.42f), horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SVGImage(matchShortModel.awayTeam?.crest.toString())
                TextNormal(
                    matchShortModel.awayTeam?.shortName.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

    }

}


@Composable
fun ScoreMatch(matchModel: MatchShortModel) {


    when (matchModel.status) {
        SCHEDULED -> {
            TextNormal(" - ")
        }

        TIMED -> {
            TextNormal(matchModel.utcDate.toTimeFormat())
        }

        IN_PLAY -> {
            TextNormal("${matchModel.scoreFullTime.home} : ${matchModel.scoreFullTime.away}")
            Text(
                stringResource(R.string.match_live),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = GREEN_LIVE
            )
        }

        PAUSED -> {
            TextNormal("${matchModel.scoreFullTime.home} : ${matchModel.scoreFullTime.away}")
            Text(
                stringResource(R.string.match_paused),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = GREEN_LIVE
            )
        }

        FINISHED -> {
            TextNormal("${matchModel.scoreFullTime.home} : ${matchModel.scoreFullTime.away}")
        }

        SUSPENDED -> {
            Text(
                stringResource(R.string.match_suspend),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = RED_ERROR
            )
        }

        POSTPONED -> {
            Text(
                stringResource(R.string.match_postponed),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = RED_ERROR
            )
        }

        CANCELLED -> {
            Text(
                stringResource(R.string.match_cancelled),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = RED_ERROR
            )
        }

        AWARDED -> {
            Text(
                matchModel.status.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = RED_ERROR
            )
        }
    }

}