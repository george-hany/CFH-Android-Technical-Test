package com.core.data.model.home


import com.squareup.moshi.Json

data class Venue(
    @Json(name = "categories")
    val categories: List<Category?>? = null,
    @Json(name = "createdAt")
    val createdAt: Int? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "location")
    val location: Location? = null,
    @Json(name = "name")
    val name: String? = null
)