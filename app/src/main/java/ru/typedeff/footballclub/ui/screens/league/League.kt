package ru.typedeff.footballclub.ui.screens.league

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.typedeff.footballclub.ui.widgets.TopBar

@Composable
fun LeagueScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopBar("LeagueScreen", onLeftClick = {
                navController.popBackStack()
            })
        }) { padding ->
        Box(modifier = Modifier.padding(padding)) { Button(onClick = {  }) { } }
    }
}