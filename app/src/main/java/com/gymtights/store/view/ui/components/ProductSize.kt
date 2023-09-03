package com.gymtights.store.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gymtights.store.data.model.Product
import com.gymtights.store.view.ui.theme.GymTightsTheme

@Composable
fun ProductSize(product: List<Product>, selectedProduct: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        val sizesList = product[selectedProduct].availableSizes
        if (!sizesList.isNullOrEmpty()) {
            sizesList.forEach {
                Box(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(50.dp).border(width = 1.dp, color = if (it.inStock) Color.Black else Color.LightGray)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        color = if (it.inStock) Color.Black else Color.Gray,
                        text = it.size
                    )
                }
            }
        }
    }
}


@Composable
@Preview(name = "Preview")
fun ProductSizePreview() {
    GymTightsTheme {
//        ProductSize()
    }
}
