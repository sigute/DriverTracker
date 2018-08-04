package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class Member(
        @SerializedName("active") val active: Boolean,
        @SerializedName("app_version") val appVersion: Any,
        @SerializedName("client_identifier") val clientIdentifier: Any,
        @SerializedName("company_id") val companyId: Int,
        @SerializedName("current_member") val currentMember: Boolean,
        @SerializedName("device_name") val deviceName: Any,
        @SerializedName("driver") val driver: Boolean,
        @SerializedName("email") val email: String,
        @SerializedName("first_name") val firstName: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("hourly_rate") val hourlyRate: String,
        @SerializedName("id") val id: Int,
        @SerializedName("last_name") val lastName: String,
        @SerializedName("tenant_id") val tenantId: Int,
        @SerializedName("tenant_status") val tenantStatus: String,
        @SerializedName("tenant_active") val tenantActive: Boolean,
        @SerializedName("terms_accepted") val termsAccepted: Boolean,
        @SerializedName("order_document") val orderDocument: Any,
        @SerializedName("order_confirmed") val orderConfirmed: Boolean,
        @SerializedName("working_since") val workingSince: Any,
        @SerializedName("last_known_position") val lastKnownPosition: LastKnownPosition
)