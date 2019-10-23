package com.ekiz.products.util

import java.io.IOException

sealed class Failure : IOException() {

    class ApiError(var code: Int, override var message: String) : Failure()
    object EmptyResponse : Failure()
    object NoConnectionError : Failure()

}