package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.CompetitionModel


@Composable
fun AreaItem(areaModel: AreaModel?) {
    if (areaModel == null) return
    BaseItem(areaModel.name, areaModel.flag)
}

@Composable
fun CompetitionItem(competitionModel: CompetitionModel?, onRightBtn: ((Boolean) -> Unit)) {
    if (competitionModel == null) return
    BaseItem(
        competitionModel.name,
        competitionModel.emblem,
        isFavorite = competitionModel.isFavorite,
        onRightBtn = onRightBtn
    )
}

@Composable
fun BaseItem(
    title: String,
    leftIcon: String,
    isFavorite: Boolean = false,
    onRightBtn: ((Boolean) -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(42.dp)
            .fillMaxWidth()
    ) {
        SVGImage(leftIcon)
        TextNormal(title, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.weight(1f))
        if (onRightBtn != null) FavoriteButton(isFavorite, onRightBtn)
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "")
    }
}

