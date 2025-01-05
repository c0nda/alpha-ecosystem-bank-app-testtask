package com.listener.bankapp.domain.models

data class BankCard(
    val number: Number,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: String,
    val bank: Bank
)