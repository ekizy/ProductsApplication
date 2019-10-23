package com.ekiz.products.scenes.main

import android.app.Application
import android.content.Context
import com.ekiz.products.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    context: Context
) : BaseViewModel(context.applicationContext as Application)