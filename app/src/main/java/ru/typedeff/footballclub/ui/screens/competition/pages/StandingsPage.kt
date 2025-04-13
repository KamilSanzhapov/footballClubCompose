package ru.typedeff.footballclub.ui.screens.competition.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.R
import ru.typedeff.footballclub.ui.screens.competition.CompetitionViewModel


@Composable
fun StandingsPage() {
    val vm = koinViewModel<CompetitionViewModel>()
    val standingsState = vm.standingsLiveData.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        StandingsItem(
            false, getTitlesRow()
        )
        LazyColumn {
            items(standingsState.value?.size ?: 0) { index ->
                StandingsItem(
                    index % 2 == 0, standingsState.value?.get(index)?.strings ?: emptyList()
                )
            }
        }
    }

}


val listWeightsRow = listOf(
    0.05555556f,
    0.45f,
    0.05555556f,
    0.05555556f,
    0.05555556f,
    0.05555556f,
    0.05555556f,
    0.05555556f,
    0.05555556f,
    0.05555556f
)

//
@Composable
fun StandingsItem(lightBackground: Boolean, listNamesRow: List<String>) {

    if (listNamesRow.size != listWeightsRow.size) RuntimeException("Not valid list")
    Row(modifier = Modifier.background(if (lightBackground) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.background )) {
        listWeightsRow.forEachIndexed { index, weight ->
            Text(
                text = listNamesRow[index],
                maxLines = 1,
                modifier = Modifier.weight(weight),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = if (index != 1) TextAlign.Center else TextAlign.Start,

                )
        }
    }
}

@Composable
fun getTitlesRow() = listOf(
    stringResource(R.string.standings_position),
    stringResource(R.string.standings_club),
    stringResource(R.string.standings_all_games),
    stringResource(R.string.standings_won),
    stringResource(R.string.standings_draw),
    stringResource(R.string.standings_lost),
    stringResource(R.string.standings_goals_for),
    stringResource(R.string.standings_goals_against),
    stringResource(R.string.standings_goals_diff),
    stringResource(R.string.standings_points),
)