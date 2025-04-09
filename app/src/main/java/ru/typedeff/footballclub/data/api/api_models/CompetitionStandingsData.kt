package ru.typedeff.footballclub.data.api.api_models

import com.google.gson.annotations.SerializedName


data class CompetitionStandingsData(
    @SerializedName("competition") var competition: CompetitionShortData? = null,
    @SerializedName("season") var season: CurrentSeasonData? = null,
    @SerializedName("standings") var standings: ArrayList<StandingsData> = arrayListOf()

)


data class StandingsData(

    @SerializedName("stage") var stage: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("group") var group: String? = null,
    @SerializedName("table") var table: ArrayList<TableData> = arrayListOf()

)


data class TableData(

    @SerializedName("position") var position: Int? = null,
    @SerializedName("team") var team: TeamData? = null,
    @SerializedName("playedGames") var playedGames: Int? = null,
    @SerializedName("form") var form: String? = null,
    @SerializedName("won") var won: Int? = null,
    @SerializedName("draw") var draw: Int? = null,
    @SerializedName("lost") var lost: Int? = null,
    @SerializedName("points") var points: Int? = null,
    @SerializedName("goalsFor") var goalsFor: Int? = null,
    @SerializedName("goalsAgainst") var goalsAgainst: Int? = null,
    @SerializedName("goalDifference") var goalDifference: Int? = null

)


data class TeamData(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("shortName") var shortName: String? = null,
    @SerializedName("tla") var tla: String? = null,
    @SerializedName("crest") var crest: String? = null

)
