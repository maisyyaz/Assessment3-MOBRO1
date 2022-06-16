package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Data(
    @Json(name = "current_page")
    val currentPage: Int,
    @Json(name = "data")
    val `data`: List<DataX>,
    @Json(name = "first_page_url")
    val firstPageUrl: String,
    @Json(name = "from")
    val from: Int,
    @Json(name = "last_page")
    val lastPage: Int,
    @Json(name = "last_page_url")
    val lastPageUrl: String,
    @Json(name = "links")
    val links: List<Link>,
    @Json(name = "next_page_url")
    val nextPageUrl: Any,
    @Json(name = "path")
    val path: String,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "prev_page_url")
    val prevPageUrl: Any,
    @Json(name = "to")
    val to: Int,
    @Json(name = "total")
    val total: Int
)