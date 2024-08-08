package com.core.data.model.home


import com.squareup.moshi.Json

data class Location(
    @Json(name = "address")
    val address: String? = null,
    @Json(name = "cc")
    val cc: String? = null,
    @Json(name = "city")
    val city: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "crossStreet")
    val crossStreet: String? = null,
    @Json(name = "distance")
    val distance: Int? = null,
    @Json(name = "formattedAddress")
    val formattedAddress: List<String?>? = null,
    @Json(name = "labeledLatLngs")
    val labeledLatLngs: List<LabeledLatLng?>? = null,
    @Json(name = "lat")
    val lat: Double? = null,
    @Json(name = "lng")
    val lng: Double? = null,
    @Json(name = "postalCode")
    val postalCode: String? = null,
    @Json(name = "state")
    val state: String? = null
)