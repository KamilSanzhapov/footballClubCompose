package ru.typedeff.footballclub.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DarkGray,
    onPrimary = White_2,
    secondary = DeepPurple,
    onSecondary = White_2,
    background = Gray,
    onBackground = White_2,
    surface = Gray_2
)

private val LightColorScheme = lightColorScheme(
    primary = LightBlue,
    onPrimary = White_2,
    secondary = Purple80,
    background = White_2,
    onBackground = Black,
    surface = White
)


@Composable
fun FootballClubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors, typography = Typography, content = content
    )
}
