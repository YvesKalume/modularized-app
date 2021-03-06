package com.yvkalume.modularized.app

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.yvkalume.modularized.app.koin.myModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(myModules)
        }
    }
}