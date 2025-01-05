package com.listener.bankapp.data

import com.listener.bankapp.data.dto.BankCardDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{bin}")
    suspend fun getBankCardInfoByBIN(
        @Path("bin") bin: Long
    ): BankCardDTO
}