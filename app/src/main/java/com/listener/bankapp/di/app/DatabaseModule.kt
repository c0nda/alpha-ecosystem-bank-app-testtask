package com.listener.bankapp.di.app

import android.content.Context
import androidx.room.Room
import com.listener.bankapp.data.local.room.BankCardDB
import com.listener.bankapp.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideBankCardDatabase(context: Context): BankCardDB {
        return Room.databaseBuilder(context, BankCardDB::class.java, Constants.BANK_CARD_DB_NAME)
            .fallbackToDestructiveMigration().build()
    }
}