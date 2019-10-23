package com.ekiz.products.base

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Suppress("UNCHECKED_CAST")
    protected val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        val persistentViewModelClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>
        return@lazy ViewModelProviders.of(this, viewModelFactory).get(persistentViewModelClass)
    }

    abstract fun layoutId(): Int

}