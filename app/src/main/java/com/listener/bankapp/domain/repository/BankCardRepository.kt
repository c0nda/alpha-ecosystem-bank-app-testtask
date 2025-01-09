package com.listener.bankapp.domain.repository

import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.models.BankCardHistory
import com.listener.bankapp.utils.Request
import kotlinx.coroutines.flow.Flow

interface BankCardRepository {

    suspend fun loadBankCardInfo(bin: Long): Flow<Request<BankCard>>

    suspend fun loadRequestHistory(): List<BankCardHistory>
}