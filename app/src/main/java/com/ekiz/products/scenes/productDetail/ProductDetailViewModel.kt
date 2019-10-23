package com.ekiz.products.scenes.productDetail

import android.app.Application
import android.content.Context
import com.ekiz.products.base.BaseViewModel
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    context: Context
) : BaseViewModel(context.applicationContext as Application)