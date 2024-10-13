package com.micahnyabuto.weatherscout.DI

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DaggerHiltClass: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}