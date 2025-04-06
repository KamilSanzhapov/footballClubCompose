package ru.typedeff.footballclub.ui.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.usecases.GetAvailableAreasUseCase


sealed class LoadState {
    object Loading : LoadState()
    object Loaded : LoadState()
    class Error(val e: String) : LoadState()
}

class MainViewModel(private val getAreaEuropeUseCase: GetAvailableAreasUseCase) : ViewModel() {

    val stateLoad = MutableLiveData<LoadState>()
    val areaLiveData = MutableLiveData<ListAreaModel>()

    init {
        loadEuropeArea()
    }


    fun loadEuropeArea() {

        viewModelScope.launch {
            stateLoad.value = LoadState.Loaded
            val result = getAreaEuropeUseCase.execute()

            areaLiveData.value = result
            stateLoad.value = LoadState.Loaded
        }
    }


}