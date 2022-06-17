package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Product(
    @Json(name = "code")
    val code: Int = 0,
    @Json(name = "data")
    val `data`: Data = Data(),
    @Json(name = "message")
    val message: String = "",
    @Json(name = "status")
    val status: String = ""
)