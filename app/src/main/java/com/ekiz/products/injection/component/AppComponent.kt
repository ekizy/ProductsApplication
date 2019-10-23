package com.ekiz.products.injection.component

import com.ekiz.products.injection.DaggerApplication
import com.ekiz.products.injection.module.ActivitiesModule
import com.ekiz.products.injection.module.AppModule
import com.ekiz.products.injection.module.FragmentsModule
import com.ekiz.products.injection.module.NetworkModule
import com.ekiz.products.injection.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)

internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()

}