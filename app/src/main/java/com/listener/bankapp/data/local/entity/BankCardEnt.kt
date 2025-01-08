package com.listener.bankapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BankCard")
data class BankCardEnt(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val bin: Long,
    val errorMessage: String?,
    val numberLength: Int? = null,
    val numberLuhn: Boolean? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val countryName: String? = null,
    val countryEmoji: String? = null,
    val countryLatitude: Int? = null,
    val countryLongitude: Int? = null,
    val bankName: String? = null,
    val bankUrl: String? = null,
    val bankPhone: String? = null,
    val bankCity: String? = null
)
