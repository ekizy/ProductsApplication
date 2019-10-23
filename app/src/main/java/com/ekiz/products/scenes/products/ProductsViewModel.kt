package com.ekiz.products.scenes.products

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.ekiz.products.base.BaseViewModel
import com.ekiz.products.data.repository.ProductsRepository
import com.ekiz.products.data.uimodels.ProductsContainerUIModel
import com.ekiz.products.util.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    context: Context,
    val repository: ProductsRepository
) : BaseViewModel(context.applicationContext as Application) {

    var result: MutableLiveData<ProductsContainerUIModel> = MutableLiveData()
    val isProgressVisible: MutableLiveData<Boolean> = MutableLiveData()
    init {
        getProducts()
    }

    private fun getProducts() = bgScope.launch {
        isProgressVisible.postValue(true)
        try {
            val products = repository.getProducts()
            withContext(Dispatchers.Main) {
                isProgressVisible.postValue(false)
                handleSuccess(products)
            }
        } catch (failure: Failure) {
            withContext(Dispatchers.Main) {
                isProgressVisible.postValue(false)
                handleFailure(failure)
            }
        }
    }

    private fun handleSuccess(articleContainerModel: ProductsContainerUIModel) {
        this.result.value = articleContainerModel
    }

    private fun handleFailure(failure: Failure) {
        print(failure.message)
    }

}