package ru.typedeff.footballclub.ui.widgets

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.typedeff.footballclub.ui.theme.Gold


@Composable
fun FavoriteButton(favoriteStartState: Boolean, switchState: (Boolean) -> Unit) {

    var isFavorite by remember { mutableStateOf(favoriteStartState) }

    IconToggleButton(
        checked = isFavorite, onCheckedChange = {
            isFavorite = !isFavorite
            switchState.invoke(isFavorite)
        }) {
        Crossfade(
            targetState = isFavorite, animationSpec = tween(700)
        ) { animState ->
            Icon(
                tint = Gold,
                imageVector = if (animState) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = null
            )
        }

    }
}