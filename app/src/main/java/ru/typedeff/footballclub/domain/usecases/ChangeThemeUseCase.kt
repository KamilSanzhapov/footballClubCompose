package ru.typedeff.footballclub.domain.usecases

import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ThemeModel
import ru.typedeff.footballclub.domain.repos.AreaRepository
import ru.typedeff.footballclub.domain.repos.SettingsRepository

class ChangeThemeUseCase(private val settingsRepository: SettingsRepository) {

    fun save(theme: ThemeModel) {
        return settingsRepository.setTheme(theme)
    }


    fun get(): ThemeModel {
        return settingsRepository.getTheme()
    }
}