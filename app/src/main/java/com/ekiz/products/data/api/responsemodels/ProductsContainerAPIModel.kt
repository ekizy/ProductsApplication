package com.ekiz.products.data.api.responsemodels

import com.ekiz.products.data.uimodels.ProductsContainerUIModel
import com.squareup.moshi.Json

data class ProductsContainerAPIModel(
    @Json(name = "filters") val filters: Array<String>? = null,
    @Json(name = "header") val header: ProductHeaderAPIModel? = null,
    @Json(name = "products") val products: Array<ProductAPIModel>? = null
) {

    fun convertToUiModel() =
        ProductsContainerUIModel(
            filters,
            header?.convertToUiModel(),
            products?.map { it.convertToUiModel() })

}