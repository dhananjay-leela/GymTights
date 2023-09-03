package com.gymtights.store.data.repository

import com.gymtights.store.data.model.Products
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class MockProductsApiService: ProductsApiService {
    private var getProductsResponse: Response<Products>? = null

    override suspend fun getProducts(): Response<Products> {
        return getProductsResponse!!
    }

    fun whenGetProductsIsSuccessful(products: Products) {
        getProductsResponse = Response.success(products)
    }

    fun whenGetProductsIsFailed(errorMessage: String) {
        getProductsResponse = Response.error(404, errorMessage.toResponseBody())
    }
}