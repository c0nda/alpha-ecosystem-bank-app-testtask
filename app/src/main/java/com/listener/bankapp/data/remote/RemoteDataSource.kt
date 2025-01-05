package com.listener.bankapp.data.remote

import com.listener.bankapp.domain.models.BankCard

interface RemoteDataSource {

    suspend fun loadBankCardInfoByBin(bin: Long): BankCard
}