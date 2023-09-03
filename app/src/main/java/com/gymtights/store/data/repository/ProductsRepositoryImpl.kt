package com.gymtights.store.data.repository

import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Error
import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Success

class ProductsRepositoryImpl(private val apiService: ProductsApiService): ProductsRepository {

    override suspend fun getProducts(): ProductsRepository.GetProductResponse {
        return try {
            val data = apiService.getProducts()

            when {
                data.isSuccessful && data.body() != null -> Success(data.body()!!)
                else -> Error(data.message())
            }
        } catch (e: Exception) {
            val exceptionMsg = e.message ?: "Unknown Exception Occurred"
            return Error(exceptionMsg)
        }
    }
}