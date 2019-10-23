package com.ekiz.products.data.uimodels

import androidx.annotation.Keep
import java.io.Serializable

@Keep
open class ProductsContainerUIModel(
    val filters: Array<String>? = null,
    val header: ProductHeaderUIModel? = null,
    val products: List<ProductUIModel>? = null
) : Serializable