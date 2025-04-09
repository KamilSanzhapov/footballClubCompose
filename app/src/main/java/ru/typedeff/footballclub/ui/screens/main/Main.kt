package ru.typedeff.footballclub.ui.screens.main


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.R
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.navigation.Screen
import ru.typedeff.footballclub.ui.widgets.AreaItem
import ru.typedeff.footballclub.ui.widgets.ListCard
import ru.typedeff.footballclub.ui.widgets.TopBar


@Composable
fun MainScreen(
    navController: NavHostController
) {
    val viewModel: MainViewModel = koinViewModel()
    val areaState = viewModel.areaLiveData.observeAsState()
    Scaffold(topBar = {
        TopBar(
            title = stringResource(R.string.app_name),
            onRightClick = { navController.navigate(Screen.Settings.screenName) })
    }, floatingActionButton = {
        FloatingActionButton({ viewModel.loadEuropeArea() }) {
            Icon(Icons.Filled.Refresh, "Refresh action")
        }
    }) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            LazyColumn(Modifier.padding(start = 8.dp, end = 8.dp, top = 12.dp)) {
                items(areaState.value?.areas?.size ?: 0) { index ->
                    areaState.value?.areas?.get(index)?.let { area ->
                        AreaCard(area) {
                            navController.navigate(Screen.Area.screenName + "/${area.id}")
                        }
                    }
                }
            }
        }
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


