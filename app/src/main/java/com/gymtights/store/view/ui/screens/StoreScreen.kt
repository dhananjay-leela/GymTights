package com.gymtights.store.view.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gymtights.store.view.ui.ProductsViewModel
import com.gymtights.store.view.ui.components.ProductsGrid
import com.gymtights.store.view.ui.components.ProductScreenHeader
import com.gymtights.store.view.ui.theme.GymTightsTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gymtights.store.data.model.Product

@Composable
fun ProductsListScreen(viewModel: ProductsViewModel) {
    val products by viewModel.productsList.observeAsState()
    var showProductInfo by remember { mutableStateOf(false) }
    var clickedProductList: List<Product> by remember { mutableStateOf(emptyList()) }

    if (showProductInfo) {
        ProductInfoScreen(clickedProductList) { showProductInfo = false }
    } else {
        ProductListScreen(products = products, onShowProductInfoChanged = {showProductInfo =  it}, onProductListChanged = {clickedProductList = it})
    }
}

@Composable
fun ProductListScreen(
    products: List<Product>?,
    onShowProductInfoChanged: (Boolean) -> Unit,
    onProductListChanged: (List<Product>) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        ProductScreenHeader()
        Spacer(modifier = Modifier.size(6.dp))

        if (!products.isNullOrEmpty()) {
            ProductsGrid(
                productsList = products,
                onProductClicked = {
                    onShowProductInfoChanged(true)
                    onProductListChanged(it)
                }
            )
        }

    }
}