package ru.typedeff.footballclub.ui.screens.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.usecases.ChangeThemeUseCase

class SettingsViewModel(private val themeUseCase: ChangeThemeUseCase) : ViewModel(){
    fun loadData() {
        themeLiveData.value = themeUseCase.get().toggle
    }

    val themeLiveData = MutableLiveData<Boolean>()

}