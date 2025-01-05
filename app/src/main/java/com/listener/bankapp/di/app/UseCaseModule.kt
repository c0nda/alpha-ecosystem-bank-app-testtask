package com.listener.bankapp.di.app

import com.listener.bankapp.domain.repository.BankCardRepository
import com.listener.bankapp.domain.usecase.GetBankCardInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetBankCardInfoUseCase(bankCardRepository: BankCardRepository) =
        GetBankCardInfoUseCase(bankCardRepository)
}