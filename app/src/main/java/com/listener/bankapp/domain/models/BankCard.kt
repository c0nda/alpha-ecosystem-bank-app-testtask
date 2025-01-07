package com.listener.bankapp.domain.models

data class BankCard(
    val number: Number? = Number(),
    val scheme: String? = "",
    val type: String? = "",
    val brand: String? = "",
    val prepaid: Boolean? = false,
    val country: Country? = Country(),
    val bank: Bank? = Bank()
)