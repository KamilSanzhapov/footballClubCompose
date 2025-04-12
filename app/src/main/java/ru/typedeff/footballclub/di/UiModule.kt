package ru.typedeff.footballclub.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.typedeff.footballclub.ui.activity.MainActivityViewModel
import ru.typedeff.footballclub.ui.screens.area.AreaViewModel
import ru.typedeff.footballclub.ui.screens.competition.CompetitionViewModel
import ru.typedeff.footballclub.ui.screens.main.MainViewModel
import ru.typedeff.footballclub.ui.screens.setting.SettingsViewModel

val uiModule = module {

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(
            themeUseCase = get()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(
            getAreaEuropeUseCase = get(), favoriteCompetitionUseCase = get()
        )
    }
    viewModel<AreaViewModel> {
        AreaViewModel(
            getCompetitionByIdUseCase = get(),
            getAreaByIdUseCase = get(),
            favoriteCompetitionUseCase = get(),
            areaId = get()
        )
    }

    viewModel<SettingsViewModel> { SettingsViewModel(themeUseCase = get()) }

    viewModel<CompetitionViewModel> {
        CompetitionViewModel(
            getStandingsCompetitionByIdUseCase = get(),
            getMatchesCompetitionByIdUseCase = get(),
            favoriteCompetitionUseCase = get(),
            competitionId = get()
        )
    }

}