package ru.typedeff.footballclub.di

import androidx.room.Room
import org.koin.dsl.module
import ru.typedeff.footballclub.data.api.ApiService
import ru.typedeff.footballclub.data.api.RetrofitComponent
import ru.typedeff.footballclub.data.db.AppDataBase
import ru.typedeff.footballclub.data.repos.AreaRepositoryImpl
import ru.typedeff.footballclub.data.repos.CompetitionRepositoryImpl
import ru.typedeff.footballclub.data.repos.FavoriteRepositoryImpl
import ru.typedeff.footballclub.data.repos.SettingsRepositoryImpl
import ru.typedeff.footballclub.data.shared_prefs.SharedPrefs
import ru.typedeff.footballclub.data.shared_prefs.Storage
import ru.typedeff.footballclub.domain.repos.AreaRepository
import ru.typedeff.footballclub.domain.repos.CompetitionRepository
import ru.typedeff.footballclub.domain.repos.FavoriteRepository
import ru.typedeff.footballclub.domain.repos.SettingsRepository


val dataModule = module {

    single<ApiService> {
        RetrofitComponent().getApi()
    }

    single<AreaRepository> {
        AreaRepositoryImpl(api = get())
    }

    single<CompetitionRepository> {
        CompetitionRepositoryImpl(api = get(), dataBase = get())
    }

    single<Storage> {
        SharedPrefs(context = get())
    }

    single<SettingsRepository> {
        SettingsRepositoryImpl(storage = get())
    }

    single<SettingsRepository> {
        SettingsRepositoryImpl(storage = get())
    }


    single {
        Room.databaseBuilder(
            context = get(), AppDataBase::class.java, "football_db.db"
        ).build()
    }

    single<FavoriteRepository> {
        FavoriteRepositoryImpl(db = get())
    }
}