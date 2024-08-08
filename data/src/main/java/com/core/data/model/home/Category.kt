package com.core.data.model.home


import com.squareup.moshi.Json

data class Category(
    @Json(name = "categoryCode")
    val categoryCode: Int? = null,
    @Json(name = "icon")
    val icon: Icon? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "mapIcon")
    val mapIcon: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "pluralName")
    val pluralName: String? = null,
    @Json(name = "primary")
    val primary: Boolean? = null,
    @Json(name = "shortName")
    val shortName: String? = null
)