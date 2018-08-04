package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(@SerializedName("token") val token: String)