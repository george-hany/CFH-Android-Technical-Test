package com.core.data.model.home


import com.squareup.moshi.Json

data class VenuesResponse(
    @Json(name = "meta")
    val meta: Meta? = null,
    @Json(name = "response")
    val response: Response? = null
)