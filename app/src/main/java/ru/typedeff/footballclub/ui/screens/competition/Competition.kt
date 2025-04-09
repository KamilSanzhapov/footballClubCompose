package ru.typedeff.footballclub.ui.screens.competition

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.typedeff.footballclub.ui.screens.competition.pages.MatchesPage
import ru.typedeff.footballclub.ui.screens.competition.pages.ScorersPage
import ru.typedeff.footballclub.ui.screens.competition.pages.StandingsPage
import ru.typedeff.footballclub.ui.widgets.TopBar

@Composable
fun CompetitionScreen(
    navController: NavHostController, id: String
) {
    val viewModel = koinViewModel<CompetitionViewModel>(parameters = { parametersOf(id) })
    val competitionState = viewModel.competitionLiveData.observeAsState()

    Scaffold(
        topBar = {
            TopBar(
                competitionState.value?.name ?: "",
                centerIcon = competitionState.value?.emblem ?: "",
                onLeftClick = {
                    navController.popBackStack()
                })
        }) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            CompetitionTabs()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CompetitionTabs() {
    Column(modifier = Modifier.fillMaxSize()) {
        val scope = rememberCoroutineScope()
        val pagerState = rememberPagerState(pageCount = { Tabs.entries.size })
        val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
        TabRow(
            selectedTabIndex = selectedTabIndex.value, modifier = Modifier.fillMaxWidth(),
        ) {
            Tabs.entries.forEachIndexed { index, currentTab ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    selectedContentColor = MaterialTheme.colorScheme.secondary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (selectedTabIndex.value == index) currentTab.selectedIcon else currentTab.unSelectedIcon,
                            contentDescription = "Tab Icon: ${currentTab.description}"
                        )
                    })
            }

        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            when (Tabs.entries[selectedTabIndex.value]) {
                Tabs.Standings -> StandingsPage()
                Tabs.Matches -> MatchesPage()
                Tabs.Scorers -> ScorersPage()
            }
        }
    }
}

enum class Tabs(
    val selectedIcon: ImageVector, val unSelectedIcon: ImageVector, val description: String
) {
    Standings(
        selectedIcon = Icons.AutoMirrored.Filled.List,
        unSelectedIcon = Icons.AutoMirrored.Outlined.List,
        description = "Standings"
    ),

    Matches(
        selectedIcon = Icons.Filled.DateRange,
        unSelectedIcon = Icons.Outlined.DateRange,
        description = "Matches"
    ),


    Scorers(
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        description = "Scorers"
    )
}