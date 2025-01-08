package com.listener.bankapp.di.app

import android.content.Context
import com.listener.bankapp.di.viewmodel.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        UseCaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        DatabaseModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }
}