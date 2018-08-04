package com.github.sigute.tracker.utils

import android.content.Context
import android.content.SharedPreferences

class AuthPreferences(context: Context) {
    private val AUTH_TOKEN = "AUTH_TOKEN"
    private val preferences: SharedPreferences = context.getSharedPreferences(".AuthPreferences", Context.MODE_PRIVATE)

    var token: String?
        get() = preferences.getString(AUTH_TOKEN, null)
        set(value) = preferences.edit().putString(AUTH_TOKEN, value).apply()
}