package ru.typedeff.footballclub.data.converter

import ru.typedeff.footballclub.data.shared_prefs.storageModels.ThemeData
import ru.typedeff.footballclub.domain.models.ThemeModel

fun ThemeData.toModel(): ThemeModel {
    return ThemeModel.from(theme)?: ThemeModel.LightTheme
}

fun ThemeModel.toData(): ThemeData {
    return ThemeData.from(theme)?: ThemeData.LightTheme
}
