package ru.typedeff.footballclub.ui.screens.main


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.R
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.navigation.Screen
import ru.typedeff.footballclub.ui.screens.area.CompetitionCard
import ru.typedeff.footballclub.ui.widgets.AreaItem
import ru.typedeff.footballclub.ui.widgets.ListCard
import ru.typedeff.footballclub.ui.widgets.TopBar


@Composable
fun MainScreen(
    navController: NavHostController
) {
    val viewModel: MainViewModel = koinViewModel()
    val areaState = viewModel.areaLiveData.observeAsState()
    val favoritesState = viewModel.favoriteCompetitionsLiveData.observeAsState()
    Scaffold(topBar = {
        TopBar(
            title = stringResource(R.string.app_name),
            onRightClick = { navController.navigate(Screen.Settings.screenName) })
    }, floatingActionButton = {
        FloatingActionButton({ viewModel.loadData() }) {
            Icon(Icons.Filled.Refresh, "Refresh action")
        }
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {

            if (favoritesState.value?.isNotEmpty() == true) TitleListMain(stringResource(R.string.main_heading_favorite_competition))
            LazyColumn(Modifier.padding(start = 8.dp, end = 8.dp)) {
                items(favoritesState.value ?: emptyList(), key = { it.id }) { competition ->
                    CompetitionCard(competition, {
                        navController.navigate(Screen.Competition.screenName + "/${competition.id}")
                    }, {
                        viewModel.switchFavorite(competition, it)
                    })
                }
            }
            TitleListMain(stringResource(R.string.main_heading_areas))
            LazyColumn(Modifier.padding(start = 8.dp, end = 8.dp)) {
                items(areaState.value?.areas ?: emptyList()) { area ->
                    AreaCard(area) {
                        navController.navigate(Screen.Area.screenName + "/${area.id}")
                    }
                }
            }
        }
    }
    SideEffect {
        viewModel.loadFavoriteCompetitions()
    }
}

@Composable
fun AreaCard(areaModel: AreaModel, click: () -> Unit) {
    ListCard {
        Box(modifier = Modifier.clickable(onClick = click)) {
            AreaItem(areaModel)
        }
    }
}

@Composable
fun TitleListMain(title: String) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            title,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(vertical = 2.dp, horizontal = 12.dp),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}


