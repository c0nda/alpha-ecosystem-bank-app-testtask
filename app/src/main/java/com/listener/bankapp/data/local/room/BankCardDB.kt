package com.listener.bankapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.listener.bankapp.data.local.dao.BankCardDAO
import com.listener.bankapp.data.local.entity.BankCardEnt

@Database(
    entities = [BankCardEnt::class],
    version = 1,
    exportSchema = false
)
abstract class BankCardDB: RoomDatabase() {

    abstract fun getBankCardDao(): BankCardDAO
}