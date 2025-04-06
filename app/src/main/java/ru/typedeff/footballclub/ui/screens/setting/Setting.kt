package ru.typedeff.footballclub.ui.screens.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.typedeff.footballclub.R
import ru.typedeff.footballclub.ui.widgets.TextNormal
import ru.typedeff.footballclub.ui.widgets.TopBar

@Composable
fun SettingScreen(
    navController: NavHostController, function: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(stringResource(R.string.setting_title), onLeftClick = {
                navController.popBackStack()
            })
        }) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SettingItems(function)
        }
    }
}

@Preview
@Composable
fun SettingItems(function: ((Boolean) -> Unit)? = null) {

    val viewModel: SettingsViewModel = koinViewModel()
    val themeState = viewModel.themeLiveData.observeAsState()

    var checked by remember { mutableStateOf(true) }

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
            .clickable {
                checked = !checked
            },

        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 1.dp)
                .size(20.dp),
            painter = painterResource(R.drawable.ic_dark_theme),
            contentDescription = ""
        )
        TextNormal("Ночной режим")
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            modifier = Modifier
                .padding(vertical = 14.dp)
                .scale(0.6f)
                .height(20.dp),
            checked = checked,
            onCheckedChange = {
                checked = it
                function?.invoke(it)
            })
    }

    LaunchedEffect(themeState) {
        checked = themeState.value == true
    }
    SideEffect {
        viewModel.loadData()
    }
}