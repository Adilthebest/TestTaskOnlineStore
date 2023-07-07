package com.example.testtaskonlinestore

import android.app.Application
import com.example.testtaskonlinestore.di.appModule
import com.example.testtaskonlinestore.di.dataModule
import com.example.testtaskonlinestore.di.domainModule
import com.example.testtaskonlinestore.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule, networkModule))
        }
    }
}