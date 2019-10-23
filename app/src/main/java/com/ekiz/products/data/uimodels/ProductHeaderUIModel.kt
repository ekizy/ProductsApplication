package com.ekiz.products.data.uimodels

import androidx.annotation.Keep
import java.io.Serializable

@Keep
open class ProductHeaderUIModel(
    val headerTitle: String? = null,
    val headerDescription: String? = null
) : Serializable