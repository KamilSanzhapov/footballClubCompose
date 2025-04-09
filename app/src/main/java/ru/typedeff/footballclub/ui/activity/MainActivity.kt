package ru.typedeff.footballclub.ui.activity


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.livedata.observeAsState
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.ui.theme.FootballClubTheme
import ru.typedeff.footballclub.ui.widgets.NavHostBuild


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = koinViewModel<MainActivityViewModel>()
            val themeState = vm.themeState.observeAsState()
            FootballClubTheme(darkTheme = themeState.value != false) {
                Surface {
                    NavHostBuild(vm)
                }
            }
        }
    }
}


