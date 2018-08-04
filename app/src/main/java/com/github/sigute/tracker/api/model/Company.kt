package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class Company(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("address") val address: Address,
        @SerializedName("default") val default: Boolean
)