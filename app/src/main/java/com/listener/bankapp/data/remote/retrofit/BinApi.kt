package com.listener.bankapp.data.remote.retrofit

import com.listener.bankapp.data.remote.dto.BankCardDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{bin}")
    suspend fun getBankCardInfoByBIN(
        @Path("bin") bin: Long
    ): BankCardDTO
}