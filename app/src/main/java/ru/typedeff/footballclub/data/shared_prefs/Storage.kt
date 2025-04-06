package ru.typedeff.footballclub.data.shared_prefs

import ru.typedeff.footballclub.data.shared_prefs.storageModels.ThemeData


interface Storage {
    fun getCurrentTheme(): ThemeData
    fun setCurrentTheme(theme: ThemeData)
}
