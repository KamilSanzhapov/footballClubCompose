package ru.typedeff.footballclub.ui.activity


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.navigation.Screen
import ru.typedeff.footballclub.ui.screens.area.AreaScreen
import ru.typedeff.footballclub.ui.screens.league.LeagueScreen
import ru.typedeff.footballclub.ui.screens.main.MainScreen
import ru.typedeff.footballclub.ui.screens.setting.SettingScreen
import ru.typedeff.footballclub.ui.theme.FootballClubTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = koinViewModel<MainActivityViewModel>()
            val themeState = vm.themeState.observeAsState()
            FootballClubTheme(darkTheme = themeState.value != false) {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController, startDestination = Screen.Main.screenName
                    ) {
                        composable(Screen.Main.screenName) {
                            MainScreen(navController)
                        }
                        composable(Screen.Settings.screenName) {
                            SettingScreen(navController){ it: Boolean->
                                vm.changeTheme(it)
                            }
                        }
                        composable (Screen.Area.screenName+"{id}"){ backStackEntry->
                            val id = backStackEntry.arguments?.getString("id", "")?:""
                            AreaScreen(navController, id)
                        }
                        composable (Screen.League.screenName){
                            LeagueScreen(navController)
                        }

                    }
                }
                SideEffect {
                    vm.loadData()
                }
            }
        }
    }
}