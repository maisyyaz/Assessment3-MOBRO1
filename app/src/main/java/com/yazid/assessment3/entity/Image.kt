package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Image(
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "path")
    val path: String,
    @Json(name = "size")
    val size: String,
    @Json(name = "updated_at")
    val updatedAt: String
)