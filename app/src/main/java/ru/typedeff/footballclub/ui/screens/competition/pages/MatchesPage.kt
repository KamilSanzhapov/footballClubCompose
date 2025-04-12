package ru.typedeff.footballclub.ui.screens.competition.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.ui.screens.competition.CompetitionViewModel
import ru.typedeff.footballclub.ui.widgets.MatchItem
import ru.typedeff.footballclub.ui.widgets.TextSmall
import ru.typedeff.footballclub.utils.dateFormateToDisplay
import java.time.LocalDate

@Composable
fun MatchesPage() {
    val vm = koinViewModel<CompetitionViewModel>()
    val matchesLiveState = vm.matchesLiveData.observeAsState()
    rememberCoroutineScope()
    var index = 0
    var findIndexScroll = false

    matchesLiveState.value?.let { matchesMap ->
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            matchesMap.forEach { (date, matchesList) ->
                val dateString = dateFormateToDisplay.format(date)
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        TextSmall(
                            dateString,
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                                .fillMaxWidth()
                        )

                    }

                }
                if (!findIndexScroll) {
                    val curDate = LocalDate.now()
                    if (curDate.isBefore(date)) {
                        findIndexScroll = true
                    } else {
                        index++
                    }
                }
                items(matchesList) { match ->
                    MatchItem(match) {
                        // TODO: (подробности о матче)
                    }
                }
                if (!findIndexScroll) index += matchesList.size
            }

        }
        LaunchedEffect("key1") {
            listState.scrollToItem(index)
        }
    }
}

