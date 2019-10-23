package com.ekiz.products.data.api.responsemodels

import com.ekiz.products.data.uimodels.ProductHeaderUIModel
import com.squareup.moshi.Json

data class ProductHeaderAPIModel(
    @Json(name = "headerTitle") val headerTitle: String? = null,
    @Json(name = "headerDescription") val headerDescription: String? = null
) {

    fun convertToUiModel() =
        ProductHeaderUIModel(headerTitle, headerDescription)

}