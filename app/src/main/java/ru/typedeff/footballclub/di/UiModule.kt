package ru.typedeff.footballclub.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.typedeff.footballclub.ui.screens.area.AreaViewModel
import ru.typedeff.footballclub.ui.screens.main.MainViewModel
import ru.typedeff.footballclub.ui.screens.setting.SettingsViewModel

val uiModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getAreaEuropeUseCase = get()
        )
    }
    viewModel<AreaViewModel> {
        AreaViewModel(
            getCompetitionByIdUseCase = get(), getAreaByIdUseCase = get()
        )
    }

    viewModel<SettingsViewModel> { SettingsViewModel() }
}