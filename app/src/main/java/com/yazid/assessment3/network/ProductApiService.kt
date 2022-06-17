package com.yazid.assessment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yazid.assessment3.entity.Product
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mamierus.makachi.id/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface ProductApiService {
    @GET("public/product")
    suspend fun getProduct(): Product
}

object ProductApi {
    val service: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }

    fun getProductImage(nama: String): String = nama

    enum class ApiStatus {LOADING, SUCCESS, FAILED}
}