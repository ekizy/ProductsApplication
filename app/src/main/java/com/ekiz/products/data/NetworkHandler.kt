package com.ekiz.products.data

import android.content.Context
import android.net.ConnectivityManager

class NetworkHandler(val context: Context) {

    fun hasInternetConnection(): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected
            ?: false
    }

}