package com.ekiz.products.data.api.datasource

import com.ekiz.products.data.api.responsemodels.ProductsContainerAPIModel
import com.ekiz.products.data.api.services.ProductsService
import com.ekiz.products.util.Failure
import javax.inject.Inject

class ProductsRemoteDataSource @Inject constructor(private val service: ProductsService) {

    @Throws(Failure::class)
    suspend fun getProducts(): ProductsContainerAPIModel {
        return service.getProducts()
    }

}