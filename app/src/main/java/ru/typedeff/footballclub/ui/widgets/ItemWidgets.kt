package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
fun CompetitionItem(competitionModel: CompetitionModel?) {
    if (competitionModel == null) return
    BaseItem(competitionModel.name, competitionModel.emblem)
}

@Composable
fun BaseItem(title: String, leftIcon: String, onRightBtn: (() -> Unit)? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(42.dp)
            .fillMaxWidth()
    ) {
        SVGImage(leftIcon)
        TextNormal(title)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Filled.KeyboardArrowRight, "")
    }
}

