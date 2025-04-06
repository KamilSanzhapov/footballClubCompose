package ru.typedeff.footballclub.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.typedeff.footballclub.domain.models.ThemeModel
import ru.typedeff.footballclub.domain.usecases.ChangeThemeUseCase

class MainActivityViewModel(private val themeUseCase: ChangeThemeUseCase) : ViewModel() {

    fun loadData(){
        themeState.value = themeUseCase.get().toggle
    }
    fun changeTheme(darkTheme: Boolean) {
        themeState.value = darkTheme
        themeUseCase.save(ThemeModel.from(darkTheme) ?: return)
    }

    val themeState = MutableLiveData<Boolean>(false)

}