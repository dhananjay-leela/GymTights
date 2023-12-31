package com.gymtights.store

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import org.koin.android.ext.koin.androidContext
import com.gymtights.store.Dependencies.modules
import org.koin.core.context.startKoin

class GymTightsApplication : Application(), LifecycleObserver, LifecycleOwner {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(modules)
        }
    }

    override val lifecycle: Lifecycle
        get() = ProcessLifecycleOwner.get().lifecycle

}