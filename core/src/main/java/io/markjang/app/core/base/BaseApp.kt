package io.markjang.app.core.base

import android.app.Application
import timber.log.Timber

abstract class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}