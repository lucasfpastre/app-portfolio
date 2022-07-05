package my.study.portfolio

import android.app.Application
import my.study.portfolio.data.di.DataModule
import my.study.portfolio.domain.di.DomainModule
import my.study.portfolio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}