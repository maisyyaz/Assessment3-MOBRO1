package com.yazid.assessment3.entity


import com.squareup.moshi.Json

data class DataX(
    @Json(name = "categories")
    val categories: List<Category> = listOf(),
    @Json(name = "chat")
    val chat: String = "",
    @Json(name = "created_at")
    val createdAt: String = "",
    @Json(name = "deleted_at")
    val deletedAt: Any? = Any(),
    @Json(name = "description")
    val description: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "images")
    val images: List<Image> = listOf(),
    @Json(name = "is_empty")
    val isEmpty: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "price")
    val price: String = "",
    @Json(name = "rating")
    val rating: String = "",
    @Json(name = "stock")
    val stock: String = "",
    @Json(name = "toppings")
    val toppings: List<Any> = listOf(),
    @Json(name = "updated_at")
    val updatedAt: String = ""
)