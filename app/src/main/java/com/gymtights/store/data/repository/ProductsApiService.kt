package com.gymtights.store.data.repository

import com.gymtights.store.data.model.Products
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

interface ProductsApiService {

    @GET("/training/mock-product-responses/algolia-example-payload.json")
    suspend fun getProducts() : Response<Products>

    companion object {
        fun create(retrofit: Retrofit) = retrofit.create<ProductsApiService>()
    }
}