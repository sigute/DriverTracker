package com.github.sigute.tracker.utils

import android.content.Context
import android.content.SharedPreferences

class AuthPreferences(context: Context) {
    private val AUTH_HEADER = "AUTH_HEADER"
    private val preferences: SharedPreferences = context.getSharedPreferences(".AuthPreferences", Context.MODE_PRIVATE)

    var header: String?
        get() = preferences.getString(AUTH_HEADER, null)
        set(value) = preferences.edit().putString(AUTH_HEADER, value).apply()
}