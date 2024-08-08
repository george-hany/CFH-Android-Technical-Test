package com.core.data.model.home


import com.squareup.moshi.Json

data class Response(
    @Json(name = "confident")
    val confident: Boolean? = null,
    @Json(name = "venues")
    val venues: List<Venue?>? = null
)