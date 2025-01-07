package com.listener.bankapp.data.remote

import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.utils.Request
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun loadBankCardInfoByBin(bin: Long): Flow<Request<BankCard>>
}