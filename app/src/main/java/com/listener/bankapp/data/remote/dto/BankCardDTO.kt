package com.listener.bankapp.data.remote.dto

data class BankCardDTO(
    val number: NumberDTO?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryDTO?,
    val bank: BankDTO?
)
