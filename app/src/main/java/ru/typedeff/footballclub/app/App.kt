package ru.typedeff.footballclub.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.typedeff.footballclub.di.dataModule
import ru.typedeff.footballclub.di.domainModule
import ru.typedeff.footballclub.di.uiModule


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, uiModule))
        }
    }
}