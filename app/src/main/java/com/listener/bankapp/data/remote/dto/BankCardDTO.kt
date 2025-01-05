package com.listener.bankapp.data.remote.dto

data class BankCardDTO(
    val number: NumberDTO,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: String,
    val bank: BankDTO
)
