package com.core.data.model.home


import com.squareup.moshi.Json

data class Meta(
    @Json(name = "code")
    val code: Int? = null,
    @Json(name = "requestId")
    val requestId: String? = null
)