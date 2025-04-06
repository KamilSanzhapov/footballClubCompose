package ru.typedeff.footballclub.domain.repos

import ru.typedeff.footballclub.domain.models.ThemeModel

interface SettingsRepository {
    fun getTheme(): ThemeModel
    fun setTheme(theme: ThemeModel)
}
