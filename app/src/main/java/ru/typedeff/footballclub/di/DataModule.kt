package ru.typedeff.footballclub.di

import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.api.RetrofitComponent
import ru.typedeff.footballclub.data.repos.AreaRepositoryImpl
import ru.typedeff.footballclub.domain.repos.AreaRepository
import org.koin.dsl.module
import ru.typedeff.footballclub.data.repos.CompetitionRepositoryImpl
import ru.typedeff.footballclub.domain.repos.CompetitionRepository


val dataModule = module {

    single<ApiService> {
        RetrofitComponent().getApi()
    }

    single<AreaRepository> {
        AreaRepositoryImpl(api = get())
    }

    single<CompetitionRepository> {
        CompetitionRepositoryImpl(api = get())
    }
}