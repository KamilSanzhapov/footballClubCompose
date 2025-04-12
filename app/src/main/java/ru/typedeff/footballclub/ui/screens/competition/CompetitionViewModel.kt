package ru.typedeff.footballclub.ui.screens.competition

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.typedeff.footballclub.domain.models.CompetitionModel
import ru.typedeff.footballclub.domain.models.MatchShortModel
import ru.typedeff.footballclub.domain.models.TableModel
import ru.typedeff.footballclub.domain.usecases.FavoriteCompetitionUseCase
import ru.typedeff.footballclub.domain.usecases.GetMatchesCompetitionByIdUseCase
import ru.typedeff.footballclub.domain.usecases.GetStandingsCompetitionByIdUseCase
import java.time.LocalDate


// Отображение строки в турнирной таблице
data class StandingsRow(
    val id: String, val strings: List<String>
)

class CompetitionViewModel(
    private val getStandingsCompetitionByIdUseCase: GetStandingsCompetitionByIdUseCase,
    private val getMatchesCompetitionByIdUseCase: GetMatchesCompetitionByIdUseCase,
    private val favoriteCompetitionUseCase: FavoriteCompetitionUseCase,
    private val competitionId: String
) : ViewModel() {

    val competitionLiveData = MutableLiveData<CompetitionModel?>()
    val standingsLiveData = MutableLiveData<List<StandingsRow>>()
    val favoriteCompetitionsLiveData = MutableLiveData<Boolean>()
    val matchesLiveData = MutableLiveData<Map<LocalDate, List<MatchShortModel>>>()


    init {
        loadData(competitionId)
    }

    private fun loadData(id: String) {
        viewModelScope.launch {
            val competitionStandingsModel = getStandingsCompetitionByIdUseCase.execute(id)
            competitionLiveData.value = competitionStandingsModel.competition
            standingsLiveData.value = tablesToListRow(competitionStandingsModel.tables)
            _loadFavoriteCompetitions()
            _getMatches()
        }
    }

    private fun tablesToListRow(list: List<TableModel>): List<StandingsRow> {
        val resultList = list.map { tableItem ->

            val strings = listOf(
                tableItem.position.toString(),
                tableItem.team?.shortName ?: "",
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
        favoriteCompetitionsLiveData.value = favoriteCompetitionUseCase.get(id = competitionId)
    }



    private suspend fun _getMatches() {
        val matchesMap = getMatchesCompetitionByIdUseCase.execute(competitionId).groupByDateMatches
        matchesLiveData.value = matchesMap
    }

}