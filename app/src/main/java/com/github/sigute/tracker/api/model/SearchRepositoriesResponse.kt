package com.github.sigute.tracker.api.model

import com.google.gson.annotations.SerializedName

data class SearchRepositoriesResponse(@SerializedName("items") val items: List<Repository>
)
