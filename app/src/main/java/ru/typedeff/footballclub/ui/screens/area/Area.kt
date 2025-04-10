package ru.typedeff.footballclub.ui.screens.area

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.navigation.Screen
import ru.typedeff.footballclub.ui.widgets.CompetitionItem
import ru.typedeff.footballclub.ui.widgets.ListCard
import ru.typedeff.footballclub.ui.widgets.TopBar

@Composable
fun AreaScreen(
    navController: NavHostController, id: String
) {
    val vm = koinViewModel<AreaViewModel>(parameters = { parametersOf(id) })
    val areaState = vm.areaState.observeAsState()
    val competitionState = vm.competitionState.observeAsState()

    Scaffold(
        topBar = {
            TopBar(
                areaState.value?.name ?: "",
                centerLogo = areaState.value?.flag ?: "",
                onLeftClick = {
                    navController.popBackStack()
                })
        }) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
        ) {
            LazyColumn(Modifier.padding(start = 8.dp, end = 8.dp, top = 12.dp)) {
                items(competitionState.value?.competitions?.size ?: 0) { index ->
                    competitionState.value?.competitions?.get(index)?.let { competition ->
                        CompetitionCard(competition, {
                            navController.navigate(Screen.Competition.screenName + "/${competition.id}")
                        }, { favoriteState ->
                            vm.switchFavorite(competition, favoriteState)
                        })
                    }
                }
            }
        }
    }

}


@Composable
fun CompetitionCard(
    competitionModel: CompetitionModel, click: () -> Unit, onFavoriteBtn: (Boolean) -> Unit
) {
    ListCard {
        Box(modifier = Modifier.clickable(onClick = click)) {
            CompetitionItem(competitionModel, onFavoriteBtn)
        }
    }
}


