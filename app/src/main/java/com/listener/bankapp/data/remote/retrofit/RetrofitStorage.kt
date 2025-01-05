package com.listener.bankapp.data.remote.retrofit

import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.data.toDomain
import com.listener.bankapp.domain.models.BankCard
import javax.inject.Inject

class RetrofitStorage @Inject constructor(private val binApi: BinApi): RemoteDataSource {

    override suspend fun loadBankCardInfoByBin(bin: Long): BankCard {
        return binApi.getBankCardInfoByBIN(bin).toDomain()
    }
}