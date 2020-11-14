package com.example.beruangbena.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefNames = "xyz.halacity.elib"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(prefNames, Context.MODE_PRIVATE)

    fun putString(keyName: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(keyName, value)
        editor.apply()
    }


    fun putBoolean(keyName: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(keyName, value)
        editor.apply()
    }

    fun getValueString(keyName: String): String? {
        return sharedPreferences.getString(keyName, null)
    }

    fun getValueBoolean(keyName: String): Boolean? {
        return sharedPreferences.getBoolean(keyName, false)
    }
}