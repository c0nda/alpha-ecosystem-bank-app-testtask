package com.listener.bankapp.domain.repository

import com.listener.bankapp.domain.models.BankCard

interface BankCardRepository {

    suspend fun loadBankCardInfo(bin: Long): BankCard
}