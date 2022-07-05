package my.study.portfolio.presentation.di

import my.study.portfolio.domain.ListUserRepositoriesUseCase
import my.study.portfolio.presentation.MainViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {
    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            factory { MainViewModel(get()) }
        }
    }
}