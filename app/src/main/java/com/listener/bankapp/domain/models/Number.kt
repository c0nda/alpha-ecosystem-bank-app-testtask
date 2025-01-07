package com.listener.bankapp.domain.models

data class Number(
    val length: Int? = 0,
    val luhn: Boolean? = false
)
