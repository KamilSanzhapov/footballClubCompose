package ru.typedeff.footballclub.data.shared_prefs

import android.content.Context
import android.content.SharedPreferences
import ru.typedeff.footballclub.data.shared_prefs.storageModels.ThemeData

const val SHARED_PREFS_NAME = "footballclub_prefs"

sealed class SharedKeys(val key: String) {
    object Theme : SharedKeys("theme")
}

class SharedPrefs : Storage {
    var sharedPref: SharedPreferences? = null

    constructor(context: Context) {
        sharedPref =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPref?.let { it ->
            with(it.edit()) {
                apply()
            }
        }
    }


    override fun getCurrentTheme(): ThemeData {

        val themeString = sharedPref?.getString(SharedKeys.Theme.key, ThemeData.LightTheme.theme)
            ?: ThemeData.LightTheme.theme
        return ThemeData.from(themeString) ?: ThemeData.LightTheme
    }

    override fun setCurrentTheme(theme: ThemeData) {
        saveString(SharedKeys.Theme.key, theme.theme)
    }

    fun saveString(key: String, value: String) {
        sharedPref?.let { it ->
            with(it.edit()) {
                putString(key, value)
                apply()
            }
        }

    }


}
