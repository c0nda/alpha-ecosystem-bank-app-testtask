package com.listener.bankapp.data.local.room

import com.listener.bankapp.domain.models.BankCardHistory
import com.listener.bankapp.data.local.LocalDataSource
import com.listener.bankapp.data.local.entity.BankCardEnt
import com.listener.bankapp.data.toDomain
import com.listener.bankapp.data.toEntity
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.utils.Request
import javax.inject.Inject

class RoomStorage @Inject constructor(private val bankCardDB: BankCardDB) : LocalDataSource {

    override suspend fun insertRequest(bin: Long, bankCard: Request<BankCard>) {
        when (bankCard) {
            is Request.Success -> {
                val data = bankCard.data.toEntity(bin = bin)
                bankCardDB.getBankCardDao().addRequest(data)
            }

            is Request.Error -> {
                bankCardDB.getBankCardDao()
                    .addRequest(BankCardEnt(bin = bin, errorMessage = bankCard.error?.message))
            }

            is Request.Loading -> {}
        }
    }

    override suspend fun getAllRequests(): List<BankCardHistory> {
        return bankCardDB.getBankCardDao().getAllRequests().map {
            it.toDomain()
        }
    }
}