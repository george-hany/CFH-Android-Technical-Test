package com.core.data.model.home


import com.squareup.moshi.Json

data class LabeledLatLng(
    @Json(name = "label")
    val label: String? = null,
    @Json(name = "lat")
    val lat: Double? = null,
    @Json(name = "lng")
    val lng: Double? = null
)