package com.gymtights.store.data.repository

import com.gymtights.store.data.model.AvailableSize
import com.gymtights.store.data.model.FeaturedMedia
import com.gymtights.store.data.model.Media
import com.gymtights.store.data.model.Product
import com.gymtights.store.data.model.Products

val mockProducts = Products(
    hits = listOf(
        Product(
            id = 123,
            sku = "098",
            inStock = true,
            sizeInStock = listOf(),
            availableSizes = listOf(
                AvailableSize(
                    123,
                    true,
                    1,
                    1,
                    "",
                    "098"
                )
            ),
            handle = "",
            title = "",
            description = "",
            type = "",
            gender = listOf(),
            colour = "",
            price = 123,
            featuredMedia = FeaturedMedia(
                adminGraphqlApiId = "",
                createdAt = "",
                height = 123,
                id = 123,
                position = 1,
                productId = 123,
                src = "",
                updatedAt = "",
                variantIds = listOf(),
                width = 1,
                alt = ""
            ),
            media = listOf(
                Media(
                    adminGraphqlApiId = "",
                    createdAt = "",
                    height = 123,
                    id = 1234,
                    position = 1,
                    productId = 123,
                    src = "",
                    updatedAt = "",
                    variantIds = listOf(),
                    width = 1,
                    alt = ""
                )
            ),
            objectID = "",
            fit = null,
            labels = null,
            compareAtPrice = null,
            discountPercentage = null
        )
    )
)