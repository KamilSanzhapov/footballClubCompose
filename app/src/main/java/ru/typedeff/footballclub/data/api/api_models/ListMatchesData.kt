package ru.typedeff.footballclub.data.api.api_models

import com.google.gson.annotations.SerializedName

data class ListMatchesData(
    @SerializedName("matches"     ) var matches     : ArrayList<MatchData> = arrayListOf()
)


data class MatchData (
    @SerializedName("competition"   ) var competition   : CompetitionData?         = CompetitionData(),
    @SerializedName("id"            ) var id            : Int?                 = null,
    @SerializedName("utcDate"       ) var utcDate       : String?              = null,
    @SerializedName("status"        ) var status        : String?              = null,
    @SerializedName("minute"        ) var minute        : String?              = null,
    @SerializedName("injuryTime"    ) var injuryTime    : Int?                 = null,
    @SerializedName("attendance"    ) var attendance    : String?              = null,
    @SerializedName("venue"         ) var venue         : String?              = null,
    @SerializedName("matchday"      ) var matchday      : Int?                 = null,
    @SerializedName("stage"         ) var stage         : String?              = null,
    @SerializedName("group"         ) var group         : String?              = null,
    @SerializedName("lastUpdated"   ) var lastUpdated   : String?              = null,
    @SerializedName("homeTeam"      ) var homeTeam      : MatchTeamData?            = MatchTeamData(),
    @SerializedName("awayTeam"      ) var awayTeam      : MatchTeamData?            = MatchTeamData(),
    @SerializedName("score"         ) var score         : ScoreData?               = ScoreData(),
    @SerializedName("goals"         ) var goals         : ArrayList<GoalsData>     = arrayListOf(),
    @SerializedName("penalties"     ) var penalties     : ArrayList<PenaltiesData> = arrayListOf(),
    @SerializedName("bookings"      ) var bookings      : ArrayList<String>    = arrayListOf(),
    @SerializedName("substitutions" ) var substitutions : ArrayList<String>    = arrayListOf(),
    @SerializedName("odds"          ) var odds          : OddsData?                = OddsData(),
    @SerializedName("referees"      ) var referees      : ArrayList<RefereesData>  = arrayListOf()

)

data class MatchTeamData (

    @SerializedName("id"         ) var id         : Int?              = null,
    @SerializedName("name"       ) var name       : String?           = null,
    @SerializedName("shortName"  ) var shortName  : String?           = null,
    @SerializedName("tla"        ) var tla        : String?           = null,
    @SerializedName("crest"      ) var crest      : String?           = null,
    @SerializedName("coach"      ) var coach      : Coach?            = Coach(),
    @SerializedName("leagueRank" ) var leagueRank : Int?              = null,
    @SerializedName("formation"  ) var formation  : String?           = null,
    @SerializedName("lineup"     ) var lineup     : ArrayList<String> = arrayListOf(),
    @SerializedName("bench"      ) var bench      : ArrayList<String> = arrayListOf()

)


data class Coach (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("nationality" ) var nationality : String? = null

)

data class ScoreData (
    @SerializedName("winner"   ) var winner   : String?   = null,
    @SerializedName("duration" ) var duration : String?   = null,
    @SerializedName("fullTime" ) var fullTime : ScorePeriodData? = ScorePeriodData(),
    @SerializedName("halfTime" ) var halfTime : ScorePeriodData? = ScorePeriodData()
)

data class ScorePeriodData (
    @SerializedName("home" ) var home : Int? = null,
    @SerializedName("away" ) var away : Int? = null
)

data class GoalsData (

    @SerializedName("minute"     ) var minute     : Int?    = null,
    @SerializedName("injuryTime" ) var injuryTime : String? = null,
    @SerializedName("type"       ) var type       : String? = null,
    @SerializedName("team"       ) var team       : MatchTeamShortData?   = MatchTeamShortData(),
    @SerializedName("scorer"     ) var scorer     : PlayerData? = PlayerData(),
    @SerializedName("assist"     ) var assist     : String? = null,
    @SerializedName("score"      ) var score      : ScorePeriodData?  = ScorePeriodData()

)
data class MatchTeamShortData (
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null
)

data class PlayerData (
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null
)

data class PenaltiesData (

    @SerializedName("player" ) var player : PlayerData?  = PlayerData(),
    @SerializedName("team"   ) var team   : MatchTeamShortData?    = MatchTeamShortData(),
    @SerializedName("scored" ) var scored : Boolean? = null

)

data class OddsData (

    @SerializedName("homeWin" ) var homeWin : Double? = null,
    @SerializedName("draw"    ) var draw    : Double? = null,
    @SerializedName("awayWin" ) var awayWin : Double? = null

)
data class RefereesData (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("type"        ) var type        : String? = null,
    @SerializedName("nationality" ) var nationality : String? = null

)