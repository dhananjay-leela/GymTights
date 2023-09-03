package com.gymtights.store.data.model

import com.google.gson.annotations.SerializedName

data class Products (
    val hits: List<Product>
)

data class Product(
    val id: Long,
    val sku: String,
    val inStock: Boolean,
    val sizeInStock: List<String>,
    @SerializedName("availableSizes")
    val availableSizes: List<AvailableSize>,
    val handle: String,
    val title: String,
    val description: String,
    val type: String,
    val gender: List<String>,
    val fit: String?, // nullable
    val labels: List<String>?, // nullable
    val colour: String,
    val price: Int,
    val compareAtPrice: Int?, // nullable
    val discountPercentage: Int?, // nullable
    @SerializedName("featuredMedia")
    val featuredMedia: FeaturedMedia,
    val media: List<Media>,
    val objectID: String
)

data class AvailableSize(
    val id: Long,
    @SerializedName("inStock")
    val inStock: Boolean,
    val inventoryQuantity: Int,
    val price: Int,
    val size: String,
    val sku: String
)

data class FeaturedMedia(
    @SerializedName("admin_graphql_api_id")
    val adminGraphqlApiId: String,
    val alt: String?, // nullable
    val createdAt: String,
    val height: Int,
    val id: Long,
    val position: Int,
    val productId: Long,
    val src: String,
    val updatedAt: String,
    val variantIds: List<String>, // empty list
    val width: Int
)

data class Media(
    @SerializedName("admin_graphql_api_id")
    val adminGraphqlApiId: String,
    val alt: String?, // nullable
    val createdAt: String,
    val height: Int,
    val id: Long,
    val position: Int,
    val productId: Long,
    val src: String,
    val updatedAt: String,
    val variantIds: List<String>, // empty list
    val width: Int
)