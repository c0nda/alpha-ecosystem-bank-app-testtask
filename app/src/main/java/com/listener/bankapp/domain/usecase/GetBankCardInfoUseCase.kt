package com.listener.bankapp.domain.usecase

import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.repository.BankCardRepository
import javax.inject.Inject

class GetBankCardInfoUseCase @Inject constructor(private val bankCardRepository: BankCardRepository) {

    suspend fun execute(bin: Long): BankCard {
        return bankCardRepository.loadBankCardInfo(bin)
    }
}