package com.listener.bankapp.data.repository

import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.repository.BankCardRepository
import javax.inject.Inject

class BankCardRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BankCardRepository {

    override suspend fun loadBankCardInfo(bin: Long): BankCard {
        return remoteDataSource.loadBankCardInfoByBin(bin)
    }
}