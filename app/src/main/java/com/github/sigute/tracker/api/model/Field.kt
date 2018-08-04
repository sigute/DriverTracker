package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class Field(
        @SerializedName("active") val active: Boolean,
        @SerializedName("area_in_hectares") val areaInHectares: Double,
        @SerializedName("id") val id: Int,
        @SerializedName("client_identifier") val clientIdentifier: Int,
        @SerializedName("company") val company: Company,
        @SerializedName("sub_client_identifier") val subClientIdentifier: Any,
        @SerializedName("name") val name: String,
        @SerializedName("geometric_area") val geometricArea: GeometricArea,
        @SerializedName("polyline") val polyline: String,
        @SerializedName("centroid_longitude") val centroidLongitude: Double,
        @SerializedName("centroid_latitude") val centroidLatitude: Double,
        @SerializedName("radius") val radius: Double
)