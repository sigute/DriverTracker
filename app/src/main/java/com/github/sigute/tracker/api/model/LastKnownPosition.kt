package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class LastKnownPosition(
        @SerializedName("longitude") val longitude: Double?,
        @SerializedName("latitude") val latitude: Double?,
        @SerializedName("timestamp") val timestamp: String?
)