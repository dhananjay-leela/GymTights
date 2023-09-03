package com.gymtights.store.data.repository

import com.gymtights.store.data.model.Products

interface ProductsRepository {

    sealed class GetProductResponse {
        class Success(val content: Products) : GetProductResponse()

        class Error(val message: String) : GetProductResponse()
    }

    suspend fun getProducts() : GetProductResponse
}
