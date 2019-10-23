package com.ekiz.products.data.api.errorhandling

import com.ekiz.products.data.NetworkHandler
import com.ekiz.products.util.Failure
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ErrorHandler @Inject constructor (private val networkHandler: NetworkHandler) : Interceptor {

    @Throws(IOException::class, Failure::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkHandler.hasInternetConnection()) {
            throw Failure.NoConnectionError
        }
        val response = chain.proceed(chain.request())
        return when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    response
                } ?: run {
                    throw Failure.EmptyResponse
                }
            }
            false -> throw Failure.ApiError(response.code(), response.message() ?: "unknown api error")
        }
    }

}