package com.droidafricana.protocodetest.db

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class UserDb(appContext: Context) {

    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(appContext)

    /**
     * Get String value from SharedPreferences at 'key'. If key not found, return ""
     * @param key SharedPreferences key
     * @return String value at 'key' or "" (empty String) if key not found
     */
    fun getString(key: String): String? {
        return preferences.getString(key, "")
    }

    /**
     * Put String value into SharedPreferences with 'key' and save
     * @param key SharedPreferences key
     * @param value String value to be added
     */
    fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    /**
     * Clear SharedPreferences (remove everything)
     */
    fun clear() {
        preferences.edit().clear().apply()
    }
}