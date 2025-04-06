package ru.typedeff.footballclub.data.converter

import ru.typedeff.footballclub.data.api.api_models.AreaData
import ru.typedeff.footballclub.data.api.api_models.ListAreaData
import ru.typedeff.footballclub.domain.models.AreaModel
import ru.typedeff.footballclub.domain.models.ListAreaModel


fun ListAreaData.toModel(): ListAreaModel {

    val list = areas.map { it.toModel() }
    return ListAreaModel(
        areas = list
    )
}


fun AreaData.toModel(): AreaModel {
    return AreaModel(id ?: -1, name ?: "", flag ?: "")
}
