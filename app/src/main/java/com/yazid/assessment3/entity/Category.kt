package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Category(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = ""
)