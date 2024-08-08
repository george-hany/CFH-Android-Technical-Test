package com.core.data.model.home


import com.squareup.moshi.Json

data class Icon(
    @Json(name = "prefix")
    val prefix: String? = null,
    @Json(name = "suffix")
    val suffix: String? = null
)