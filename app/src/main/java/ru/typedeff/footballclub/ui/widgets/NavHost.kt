package ru.typedeff.footballclub.ui.widgets

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.typedeff.footballclub.navigation.Screen
import ru.typedeff.footballclub.ui.activity.MainActivityViewModel
import ru.typedeff.footballclub.ui.screens.area.AreaScreen
import ru.typedeff.footballclub.ui.screens.competition.CompetitionScreen
import ru.typedeff.footballclub.ui.screens.main.MainScreen
import ru.typedeff.footballclub.ui.screens.setting.SettingScreen


@Composable
fun NavHostBuild(vm: MainActivityViewModel){

    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screen.Main.screenName, builder = {

            composable(Screen.Main.screenName) {
                MainScreen(navController)
            }
            composable(Screen.Settings.screenName) {
                SettingScreen(navController) { it: Boolean ->
                    vm.changeTheme(it)
                }
            }
            composable(Screen.Area.screenName + "/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id", "") ?: ""
                AreaScreen(navController, id)
            }
            composable(Screen.Competition.screenName + "/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id", "") ?: ""
                CompetitionScreen(navController, id)
            }
        })
}
