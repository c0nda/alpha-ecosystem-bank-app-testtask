package com.listener.bankapp.data.remote.retrofit

import com.listener.bankapp.data.remote.RemoteDataSource
import com.listener.bankapp.data.toDomain
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.utils.Request
import com.listener.bankapp.utils.RequestUtils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrofitStorage @Inject constructor(private val binApi: BinApi): RemoteDataSource {

    override suspend fun loadBankCardInfoByBin(bin: Long): Flow<Request<BankCard>> {
        return RequestUtils.requestFlow {
            binApi.getBankCardInfoByBIN(bin).toDomain()
        }
    }
}