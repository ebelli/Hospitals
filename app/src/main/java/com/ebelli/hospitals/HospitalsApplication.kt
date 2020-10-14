package com.ebelli.hospitals

import android.app.Application
import com.ebelli.hospitals.di.modules.appModule
import com.ebelli.hospitals.di.modules.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HospitalsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HospitalsApplication)
            modules(listOf(appModule, repoModule))
        }
    }

}