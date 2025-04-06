package ru.typedeff.footballclub.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.typedeff.footballclub.data.api.api_models.AreaData
import ru.typedeff.footballclub.data.api.api_models.ListCompetitionData
import ru.typedeff.footballclub.data.api.api_models.ListAreaData

interface ApiService {

    @GET("areas")
    suspend fun getAreasByFilters(@Query("areas") id: String): ListAreaData

    @GET("areas/{id}")
    suspend fun getAreaById(@Path("id") id: String): AreaData

    @GET("competitions")
    suspend fun getCompetitionsByAreaId(@Query("areas") id: String): ListCompetitionData

    @GET("competitions/{id}/standings")
    suspend fun getCompetitionStandingsById(@Path("id") id: String)
    @GET("competitions/{id}/matches")
    suspend fun getCompetitionMatchesById(@Path("id") id: String)
    @GET("competitions/{id}/scorers")
    suspend fun getCompetitionTopScorersById(@Path("id") id: String)



}