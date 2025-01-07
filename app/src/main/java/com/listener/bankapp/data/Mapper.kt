package com.listener.bankapp.data

import com.listener.bankapp.data.remote.dto.BankCardDTO
import com.listener.bankapp.data.remote.dto.BankDTO
import com.listener.bankapp.data.remote.dto.CountryDTO
import com.listener.bankapp.data.remote.dto.NumberDTO
import com.listener.bankapp.domain.models.Bank
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.models.Country
import com.listener.bankapp.domain.models.Number

fun BankCardDTO.toDomain() = BankCard(
    number = number?.toDomain(),
    scheme = scheme,
    type = type,
    brand = brand,
    prepaid = prepaid,
    country = country?.toDomain(),
    bank = bank?.toDomain()
)

fun NumberDTO.toDomain() = Number(
    length = length,
    luhn = luhn
)

fun BankDTO.toDomain() = Bank(
    name = name,
    url = url,
    phone = phone,
    city = city
)

fun CountryDTO.toDomain() = Country(
    name = name,
    emoji = emoji,
    latitude = latitude,
    longitude = longitude
)