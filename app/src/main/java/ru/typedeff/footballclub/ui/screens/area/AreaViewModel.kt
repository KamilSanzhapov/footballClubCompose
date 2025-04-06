package ru.typedeff.footballclub.ui.screens.area

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ListCompetitionModel
import ru.typedeff.footballclub.domain.usecases.GetAreaByIdUseCase
import ru.typedeff.footballclub.domain.usecases.GetCompetitionByIdUseCase

class AreaViewModel(
    private val getCompetitionByIdUseCase: GetCompetitionByIdUseCase,
    private val getAreaByIdUseCase: GetAreaByIdUseCase
) : ViewModel() {


    val areaState = MutableLiveData<AreaModel>()
    val competitionState = MutableLiveData<ListCompetitionModel>()
    fun loadAreaInfo(id: String) {
        viewModelScope.launch {
            val res = getAreaByIdUseCase.execute(id)
            areaState.value = res
        }
    }

    fun loadCompetitionInfo(id: String){
        viewModelScope.launch {
            val res = getCompetitionByIdUseCase.execute(id)
            competitionState.value = res
        }
    }
}