package ru.typedeff.footballclub.data.api.api_models

import com.google.gson.annotations.SerializedName

data class ListCompetitionData(
    @SerializedName("count") var count: Int,
    @SerializedName("competitions") var competitions: ArrayList<CompetitionData> = arrayListOf()
)

data class CompetitionData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("emblem") var emblem: String? = null,
    @SerializedName("plan") var plan: String? = null,
    @SerializedName("currentSeason") var currentSeason: CurrentSeason? = CurrentSeason(),
    @SerializedName("numberOfAvailableSeasons") var numberOfAvailableSeasons: Int? = null,
    @SerializedName("lastUpdated") var lastUpdated: String? = null
)

data class CurrentSeason(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("startDate") var startDate: String? = null,
    @SerializedName("endDate") var endDate: String? = null,
    @SerializedName("currentMatchday") var currentMatchday: Int? = null
)
