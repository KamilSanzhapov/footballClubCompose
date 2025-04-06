package ru.typedeff.footballclub.data.shared_prefs.storageModels


enum class ThemeData(val theme: String) {
    DarkTheme("dark"), LightTheme("light");

    companion object {
        infix fun from(value: String): ThemeData? =
            ThemeData.entries.firstOrNull { it.theme == value }
    }
}
