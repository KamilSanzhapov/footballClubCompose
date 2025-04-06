package ru.typedeff.footballclub.data.api.api_models

import com.google.gson.annotations.SerializedName

data class ListAreaData(
    @SerializedName("count") var count: Int,
    @SerializedName("areas") var areas: ArrayList<AreaData> = arrayListOf()
)
data class AreaData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String?=null,
    @SerializedName("countryCode") var countryCode: String?=null,
    @SerializedName("flag") var flag: String?=null,
    @SerializedName("parentAreaId") var parentAreaId: String?=null,
    @SerializedName("parentArea") var parentArea: String?=null,
)