package com.ekiz.products.data.api.services

import com.ekiz.products.data.api.responsemodels.ProductsContainerAPIModel
import retrofit2.http.GET

interface ProductsService {

    @GET("products-test.json")
    suspend fun getProducts(
    ): ProductsContainerAPIModel

}