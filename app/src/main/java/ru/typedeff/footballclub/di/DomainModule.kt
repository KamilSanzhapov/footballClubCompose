package ru.typedeff.footballclub.di

import org.koin.dsl.module
import ru.typedeff.footballclub.domain.usecases.ChangeThemeUseCase
import ru.typedeff.footballclub.domain.usecases.FavoriteCompetitionUseCase
import ru.typedeff.footballclub.domain.usecases.GetAreaByIdUseCase
import ru.typedeff.footballclub.domain.usecases.GetAvailableAreasUseCase
import ru.typedeff.footballclub.domain.usecases.GetCompetitionByIdUseCase
import ru.typedeff.footballclub.domain.usecases.GetStandingsCompetitionByIdUseCase


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

    factory<ChangeThemeUseCase> {
        ChangeThemeUseCase(settingsRepository = get())
    }

    factory<GetStandingsCompetitionByIdUseCase> {
        GetStandingsCompetitionByIdUseCase(competitionRepository = get())
    }
    factory<FavoriteCompetitionUseCase> { FavoriteCompetitionUseCase(favoriteRepository = get()) }

}