package com.ekiz.products.data.api.responsemodels

import com.ekiz.products.data.uimodels.ProductPriceUIModel
import com.squareup.moshi.Json

data class ProductPriceAPIModel(
    @Json(name = "value") val value: Double? = null,
    @Json(name = "currency") val currency: String? = null
) {

    fun convertToUiModel() =
        ProductPriceUIModel(value, currency)

}