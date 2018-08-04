package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class GeometricArea(
        @SerializedName("type") val type: String,
        @SerializedName("coordinates") val coordinates: List<List<List<Double>>>
)