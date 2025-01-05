package com.listener.bankapp.di.app

import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.data.remote.retrofit.RetrofitStorage
import com.listener.bankapp.data.repository.BankCardRepositoryImpl
import com.listener.bankapp.domain.repository.BankCardRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindBankCardRepository(
        bankCardRepositoryImpl: BankCardRepositoryImpl
    ): BankCardRepository

    @Binds
    abstract fun bindRemoteDataSource(
        retrofitStorage: RetrofitStorage
    ) : RemoteDataSource
}