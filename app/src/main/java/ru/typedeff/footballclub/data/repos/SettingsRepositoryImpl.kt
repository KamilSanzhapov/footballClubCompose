package ru.typedeff.footballclub.data.repos

import ru.typedeff.footballclub.data.converter.toData
import ru.typedeff.footballclub.data.converter.toModel
import ru.typedeff.footballclub.data.shared_prefs.Storage
import ru.typedeff.footballclub.domain.models.ThemeModel
import ru.typedeff.footballclub.domain.repos.SettingsRepository

class SettingsRepositoryImpl(private val storage: Storage) : SettingsRepository {
    override fun getTheme(): ThemeModel {
        return storage.getCurrentTheme().toModel()
    }

    override fun setTheme(theme: ThemeModel) {
        storage.setCurrentTheme(theme.toData())
    }
}



