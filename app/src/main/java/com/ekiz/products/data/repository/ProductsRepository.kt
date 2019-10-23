package com.ekiz.products.data.repository

import com.ekiz.products.data.NetworkHandler
import com.ekiz.products.data.api.datasource.ProductsRemoteDataSource
import com.ekiz.products.data.uimodels.ProductsContainerUIModel
import com.ekiz.products.util.Failure
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val remoteDataSource: ProductsRemoteDataSource,
    private val networkHandler: NetworkHandler
) {

    @Throws(Failure::class)
    suspend fun getProducts():
            ProductsContainerUIModel {
        if (networkHandler.hasInternetConnection()) {
            return remoteDataSource.getProducts().convertToUiModel()
        } else {
            throw Failure.NoConnectionError
        }
    }

}