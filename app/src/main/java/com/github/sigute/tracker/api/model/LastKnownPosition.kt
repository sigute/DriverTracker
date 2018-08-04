package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class LastKnownPosition(
        @SerializedName("longitude") val longitude: Any,
        @SerializedName("latitude") val latitude: Any,
        @SerializedName("timestamp") val timestamp: Any
)