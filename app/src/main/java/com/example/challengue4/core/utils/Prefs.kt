package com.example.challengue4.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.challengue4.core.constans.sharedPrefName

class Prefs(val context: Context) {
    private val prefs = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)


    fun saveStringValue(key: PreferencesKeys, value: String) {
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(key.value, value)
        editor.apply()
    }

    fun getStringValue(key: PreferencesKeys): String {
        return prefs.getString(key.value, String.empty) ?: String.empty
    }

    fun saveBooleanValue(key: PreferencesKeys, value: Boolean) {
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putBoolean(key.value, value)
        editor.apply()
    }

    fun getBooleanValue(key: PreferencesKeys): Boolean {
        return prefs.getBoolean(key.value, false)
    }
 }