package com.listener.bankapp

import android.app.Application
import com.listener.bankapp.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent
            .builder()
            .appContext(this)
            .build()
    }
}