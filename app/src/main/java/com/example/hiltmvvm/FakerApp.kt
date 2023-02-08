package com.example.hiltmvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakerApp : Application() {

    companion object {
        lateinit var mInstance: FakerApp
            private set
    }

    override fun onCreate() {
        super.onCreate()

        mInstance = this
    }
}