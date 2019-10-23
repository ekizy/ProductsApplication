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
    var initialLoad = true
    init {
        getProducts()
    }

    fun getProducts() = bgScope.launch {

        if (initialLoad) {
            sendProgressSignal(true)
        }

        try {
            val products = repository.getProducts()
            withContext(Dispatchers.Main) {
                handleSuccess(products)
            }
        } catch (failure: Failure) {
            withContext(Dispatchers.Main) {
                handleFailure(failure)
            }
        }

        if (initialLoad) {
            isProgressVisible.postValue(false)
            initialLoad.not()
        }
    }

    private fun handleSuccess(articleContainerModel: ProductsContainerUIModel) {
        this.result.value = articleContainerModel
    }

    private fun handleFailure(failure: Failure) {
        print(failure.message)
    }

    fun sendProgressSignal(shouldShow: Boolean) {
        isProgressVisible.postValue(true)
    }

}