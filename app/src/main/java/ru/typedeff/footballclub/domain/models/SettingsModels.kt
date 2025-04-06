package ru.typedeff.footballclub.domain.models

enum class ThemeModel(val theme: String, val toggle: Boolean) {
    DarkTheme("dark", true), LightTheme("light", false);

    companion object {
        infix fun from(value: String): ThemeModel? =
            ThemeModel.entries.firstOrNull { it.theme == value }

        infix fun from(value: Boolean): ThemeModel? =
            ThemeModel.entries.firstOrNull { it.toggle == value }
    }
}