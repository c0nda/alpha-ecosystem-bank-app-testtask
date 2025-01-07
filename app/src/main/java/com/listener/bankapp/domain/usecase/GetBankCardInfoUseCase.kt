package com.listener.bankapp.domain.usecase

import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.repository.BankCardRepository
import com.listener.bankapp.utils.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBankCardInfoUseCase @Inject constructor(private val bankCardRepository: BankCardRepository) {

    suspend fun execute(bin: Long): Flow<Request<BankCard>> {
        return bankCardRepository.loadBankCardInfo(bin)
    }
}