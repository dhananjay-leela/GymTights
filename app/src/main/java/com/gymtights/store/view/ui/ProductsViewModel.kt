package com.gymtights.store.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gymtights.store.data.model.Product
import com.gymtights.store.data.repository.ProductsRepository
import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Error
import com.gymtights.store.data.repository.ProductsRepository.GetProductResponse.Success
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ProductsViewModel(
    ioDispatcher: CoroutineDispatcher,
    val productsRepo: ProductsRepository
) : ViewModel() {

    private val _productsList = MutableLiveData<List<Product>>()
    val productsList: LiveData<List<Product>> = _productsList

    private val errorMessage = MutableLiveData<String>()

    init {
        viewModelScope.launch(ioDispatcher) {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {
        when (val response = productsRepo.getProducts()) {
            is Success -> _productsList.postValue(response.content.hits)
            is Error -> errorMessage.postValue(response.message)
        }
    }
}