package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class Data(
    @Json(name = "current_page")
    val currentPage: Int = 0,
    @Json(name = "data")
    val `data`: List<DataX> = listOf(),
    @Json(name = "first_page_url")
    val firstPageUrl: String = "",
    @Json(name = "from")
    val from: Int = 0,
    @Json(name = "last_page")
    val lastPage: Int = 0,
    @Json(name = "last_page_url")
    val lastPageUrl: String = "",
    @Json(name = "links")
    val links: List<Link> = listOf(),
    @Json(name = "next_page_url")
    val nextPageUrl: Any? = Any(),
    @Json(name = "path")
    val path: String = "",
    @Json(name = "per_page")
    val perPage: Int = 0,
    @Json(name = "prev_page_url")
    val prevPageUrl: Any? = Any(),
    @Json(name = "to")
    val to: Int = 0,
    @Json(name = "total")
    val total: Int = 0
)