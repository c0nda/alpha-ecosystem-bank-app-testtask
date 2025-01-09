package com.listener.bankapp.domain.usecase

import com.listener.bankapp.domain.models.BankCardHistory
import com.listener.bankapp.domain.repository.BankCardRepository
import javax.inject.Inject

class GetHistoryRequestUseCase @Inject constructor(private val bankCardRepository: BankCardRepository) {

    suspend fun execute(): List<BankCardHistory> {
        return bankCardRepository.loadRequestHistory()
    }
}