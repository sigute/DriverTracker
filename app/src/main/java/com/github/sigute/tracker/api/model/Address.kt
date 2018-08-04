package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class Address(
        @SerializedName("text") val text: String,
        @SerializedName("longitude") val longitude: Double,
        @SerializedName("latitude") val latitude: Double
)