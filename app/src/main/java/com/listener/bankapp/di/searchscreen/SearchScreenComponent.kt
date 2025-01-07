package com.listener.bankapp.di.searchscreen

import com.listener.bankapp.DI
import com.listener.bankapp.di.app.NetworkModule
import com.listener.bankapp.di.app.RepositoryModule
import com.listener.bankapp.di.app.ScreenScope
import com.listener.bankapp.di.app.UseCaseModule
import com.listener.bankapp.di.viewmodel.ViewModelFactory
import dagger.Component

@Component(
    modules = [
        SearchScreenModule::class,
        UseCaseModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
@ScreenScope
interface SearchScreenComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {

        fun build(): SearchScreenComponent
    }

    companion object {
        fun create() = with(DI.appComponent) {
            DaggerSearchScreenComponent
                .builder()
                .build()
        }
    }
}