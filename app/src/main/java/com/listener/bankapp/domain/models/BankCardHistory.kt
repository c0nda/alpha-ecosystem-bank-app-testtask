package com.listener.bankapp.domain.models

data class BankCardHistory(
    val bin: Long,
    val errorMessage: String?,
    val bankCard: BankCard?
)
