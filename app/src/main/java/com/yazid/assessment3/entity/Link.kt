package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Link(
    @Json(name = "active")
    val active: Boolean = false,
    @Json(name = "label")
    val label: String = "",
    @Json(name = "url")
    val url: Any? = Any()
)