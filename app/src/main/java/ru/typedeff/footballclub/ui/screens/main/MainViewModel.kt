package ru.typedeff.footballclub.ui.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.models.ListAreaModel
import ru.typedeff.footballclub.domain.usecases.FavoriteCompetitionUseCase
import ru.typedeff.footballclub.domain.usecases.GetAvailableAreasUseCase


sealed class LoadState {
    object Loading : LoadState()
    object Loaded : LoadState()
    class Error(val e: String) : LoadState()
}

class MainViewModel(
    private val getAreaEuropeUseCase: GetAvailableAreasUseCase,
    private val favoriteCompetitionUseCase: FavoriteCompetitionUseCase
) : ViewModel() {

    val stateLoad = MutableLiveData<LoadState>()
    val areaLiveData = MutableLiveData<ListAreaModel>()
    val favoriteCompetitionsLiveData = MutableLiveData<List<CompetitionModel>>()

    init {
        loadData()
    }


    fun loadData() {
        viewModelScope.launch {
            _loadFavoriteCompetitions()
            _loadAreas()
        }
    }

    fun switchFavorite(competition: CompetitionModel, isFavorite: Boolean) {
        viewModelScope.launch {
            favoriteCompetitionUseCase.set(competition, isFavorite)
            loadFavoriteCompetitions()
        }
    }

    fun loadFavoriteCompetitions() {
        viewModelScope.launch {
            _loadFavoriteCompetitions()
        }
    }

    private suspend fun _loadFavoriteCompetitions() {
        favoriteCompetitionsLiveData.value = favoriteCompetitionUseCase.getAll()
    }

    private suspend fun _loadAreas() {
        val result = getAreaEuropeUseCase.execute()
        areaLiveData.value = result
    }

}