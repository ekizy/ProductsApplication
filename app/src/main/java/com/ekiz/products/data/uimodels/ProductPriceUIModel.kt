package com.ekiz.products.data.uimodels

import androidx.annotation.Keep
import java.io.Serializable

@Keep
open class ProductPriceUIModel(
    val value: Double? = null,
    val currency: String? = null
) : Serializable