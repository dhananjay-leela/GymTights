package com.gymtights.store.data.repository

import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Success
import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Error
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class ProductsRepositoryImplTest {

    private val expectedProducts = mockProducts

    private lateinit var apiService: MockProductsApiService
    private lateinit var repository: ProductsRepository

    @Before
    fun setUp() {
        apiService = MockProductsApiService()
        repository = ProductsRepositoryImpl(apiService)
    }

    @Test
    fun `fetching products return Success when api call is successful`() = runBlocking {
        //Given
        apiService.whenGetProductsIsSuccessful(expectedProducts)

        //When
        val response = repository.getProducts() as Success

        //Then
        assertEquals(expectedProducts, response.content)
    }

    @Test
    fun `fetching products returns Error when api call is successful`() = runBlocking {
        //Given
        val errorMessage = "An error occurred"
        apiService.whenGetProductsIsFailed(errorMessage)

        //When
        val response = repository.getProducts()

        //Then
        assertTrue(response is Error)
    }
}