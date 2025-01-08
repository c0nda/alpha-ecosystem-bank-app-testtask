package com.listener.bankapp.di.app

import com.listener.bankapp.data.local.LocalDataSource
import com.listener.bankapp.data.local.room.RoomStorage
import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.data.remote.retrofit.RetrofitStorage
import com.listener.bankapp.data.repository.BankCardRepositoryImpl
import com.listener.bankapp.domain.repository.BankCardRepository
import dagger.Binds
import dagger.Module

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

    @Binds
    abstract fun bindLocalDataSource(
        roomStorage: RoomStorage
    ) : LocalDataSource
}