package com.ekiz.products.injection.module

import com.ekiz.products.injection.scope.ProductsScope
import com.ekiz.products.scenes.products.ProductsFragment
import com.ekiz.products.scenes.products.ProductsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentsModule {

    @ProductsScope
    @ContributesAndroidInjector(modules = [ProductsModule::class])
    internal abstract fun contributeTopHeadlinesFragment(): ProductsFragment
}