package com.ekiz.products.data.uimodels

import android.text.format.DateUtils
import androidx.annotation.Keep
import java.io.Serializable
import java.util.*

@Keep
open class ProductUIModel(
    val name: String? = null,
    val type: String? = null,
    val id: String? = null,
    val color: String? = null,
    val colorCode: String? = null,
    val available: Boolean? = null,
    val imageURL: String? = null,
    val releaseDate: Date? = null,
    val description: String? = null,
    val rating: Double? = null,
    val price: ProductPriceUIModel? = null,
    val longDescription: String? = null
) : Serializable {

    fun getDateString(): String {
        releaseDate?.let {
            return DateUtils.getRelativeTimeSpanString(it.time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS)
                .toString()
        } ?: run {
            return ""
        }
    }

}