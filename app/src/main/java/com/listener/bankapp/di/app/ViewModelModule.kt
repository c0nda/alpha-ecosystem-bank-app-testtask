package com.listener.bankapp.di.app

import androidx.lifecycle.ViewModel
import com.listener.bankapp.di.viewmodel.ViewModelKey
import com.listener.bankapp.presentation.searchscreen.SearchScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchScreenViewModel::class)
    abstract fun searchScreenViewModel(viewModel: SearchScreenViewModel): ViewModel
}