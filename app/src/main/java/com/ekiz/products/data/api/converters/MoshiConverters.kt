package com.ekiz.products.data.api.converters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.*

class MoshiConverters {

    private val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    @FromJson
    fun milliSecondsToDate(value: Long?): Date? {
        if (value == null) {
            return null
        } else {
            val cal = Calendar.getInstance()
            cal.timeInMillis = value
            return cal.time
        }
    }

    @ToJson
    fun dateToTimestamp(date: Date?): Long? = date?.let { date.time }

}