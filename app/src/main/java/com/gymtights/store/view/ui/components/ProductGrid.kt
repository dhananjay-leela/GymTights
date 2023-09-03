package com.gymtights.store.view.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gymtights.store.data.model.Product
import com.gymtights.store.view.ui.theme.GymTightsTheme

@Composable
fun ProductsGrid(modifier: Modifier = Modifier, productsList: List<Product>, onProductClicked: (List<Product>) -> Unit) {
    val groupedProducts = productsList.groupBy { it.title }
    val uniqueProducts = groupedProducts.map { (_, products) -> products.first() }
    val selectedProductList = groupedProducts.values.toList()


    Column {
        Text(modifier = Modifier.padding(bottom = 10.dp), text = "${uniqueProducts.size} Products Found")
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
            content = {
                items(uniqueProducts.size) {
                    ProductCard(
                        imageUrl = uniqueProducts[it].featuredMedia.src,
                        title = uniqueProducts[it].title,
                        color = uniqueProducts[it].colour,
                        price = uniqueProducts[it].price,
                        label = uniqueProducts[it].labels?.firstOrNull()
                    ) {
                        onProductClicked(selectedProductList[it])
                    }
                }
            }
        )
    }
}


@Composable
@Preview(name = "Product Grid preview")
private fun ProductGridPreview() {
    GymTightsTheme {
//        ProductsGrid()
    }
}