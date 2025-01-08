package com.listener.bankapp.domain.models

data class BankCard(
    val number: Number? = Number(),
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: Country? = Country(),
    val bank: Bank? = Bank()
)