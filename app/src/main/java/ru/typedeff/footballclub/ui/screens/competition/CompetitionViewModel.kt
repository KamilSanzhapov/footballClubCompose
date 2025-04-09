package ru.typedeff.footballclub.ui.screens.competition

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.typedeff.footballclub.domain.models.CompetitionShortModel
import ru.typedeff.footballclub.domain.models.TableModel
import ru.typedeff.footballclub.domain.usecases.GetStandingsCompetitionByIdUseCase


// Отображение строки в турнирной таблице
data class StandingsRow(
    val id: String, val strings: List<String>
)

class CompetitionViewModel(private val getStandingsCompetitionByIdUseCase: GetStandingsCompetitionByIdUseCase, competitionId:String) :
    ViewModel() {

    val competitionLiveData = MutableLiveData<CompetitionShortModel?>()
    val standingsLiveData = MutableLiveData<List<StandingsRow>>()


    init {
        loadData(competitionId)
    }
    private fun loadData(id: String) {
        viewModelScope.launch {
            delay(1000)
            val competitionStandingsModel = getStandingsCompetitionByIdUseCase.execute(id)
            competitionLiveData.value = competitionStandingsModel.competition
            standingsLiveData.value = tablesToListRow(competitionStandingsModel.tables)
        }
    }

    private fun tablesToListRow(list: List<TableModel>): List<StandingsRow> {
        val resultList = list.map { tableItem ->

            val strings = listOf(
                tableItem.position.toString(),
                tableItem.team?.name ?: "",
                tableItem.playedGames.toString(),
                tableItem.won.toString(),
                tableItem.draw.toString(),
                tableItem.lost.toString(),
                tableItem.goalsFor.toString(),
                tableItem.goalsAgainst.toString(),
                tableItem.goalDifference.toString(),
                tableItem.points.toString()

            )

            StandingsRow(id = tableItem.team?.id.toString(), strings = strings)
        }
        return resultList
    }
}