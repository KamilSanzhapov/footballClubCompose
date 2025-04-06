package ru.typedeff.footballclub.di

import org.koin.dsl.module
import ru.typedeff.footballclub.domain.usecases.GetAreaByIdUseCase
import ru.typedeff.footballclub.domain.usecases.GetAvailableAreasUseCase
import ru.typedeff.footballclub.domain.usecases.GetCompetitionByIdUseCase


val domainModule = module {
    factory<GetAvailableAreasUseCase> {
        GetAvailableAreasUseCase(areaRepository = get())
    }

    factory<GetCompetitionByIdUseCase> {
        GetCompetitionByIdUseCase(competitionRepository = get())
    }

    factory<GetAreaByIdUseCase> {
        GetAreaByIdUseCase(areaRepository = get())
    }

}