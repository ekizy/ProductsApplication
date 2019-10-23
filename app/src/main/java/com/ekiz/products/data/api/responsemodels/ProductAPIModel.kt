package com.ekiz.products.data.api.responsemodels

import com.ekiz.products.data.uimodels.ProductUIModel
import com.squareup.moshi.Json
import java.util.*

data class ProductAPIModel(
    @Json(name = "name") val name: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "id") val id: String? = null,
    @Json(name = "color") val color: String? = null,
    @Json(name = "colorCode") val colorCode: String? = null,
    @Json(name = "available") val available: Boolean? = null,
    @Json(name = "imageURL") val imageURL: String? = null,
    @Json(name = "releaseDate") val releaseDate: Date? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "rating") val rating: Double? = null,
    @Json(name = "price") val price: ProductPriceAPIModel? = null,
    @Json(name = "longDescription") val longDescription: String? = null
) {

    fun convertToUiModel() =
        ProductUIModel(
            name,
            type,
            id,
            color,
            color,
            available,
            imageURL,
            releaseDate,
            description,
            rating,
            price?.convertToUiModel(),
            longDescription
        )

}