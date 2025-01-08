package com.listener.bankapp.data.repository

import com.listener.bankapp.data.local.LocalDataSource
import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.repository.BankCardRepository
import com.listener.bankapp.utils.Request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class BankCardRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : BankCardRepository {

    override suspend fun loadBankCardInfo(bin: Long): Flow<Request<BankCard>> {
        return remoteDataSource.loadBankCardInfoByBin(bin).onEach { request ->
            localDataSource.insertRequest(bin, request)
        }
    }
}