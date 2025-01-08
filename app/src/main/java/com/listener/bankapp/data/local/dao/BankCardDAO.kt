package com.listener.bankapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.listener.bankapp.data.local.entity.BankCardEnt

@Dao
interface BankCardDAO {

    @Insert
    fun addRequest(bankCard: BankCardEnt)

    @Query("SELECT * FROM BankCard")
    fun getAllRequests(): List<BankCardEnt>
}