package com.listener.bankapp.data.local

import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.models.BankCardHistory
import com.listener.bankapp.utils.Request

interface LocalDataSource {

    suspend fun insertRequest(bin: Long, bankCard: Request<BankCard>)

    suspend fun getAllRequests(): List<BankCardHistory>
}