package com.example.challengue4.core.utils

import android.app.Application

class PreferencesRepository: Application() {

    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}