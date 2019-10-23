package com.ekiz.products.injection.module

import android.content.Context
import com.ekiz.products.injection.DaggerApplication
import com.ekiz.products.data.api.converters.MoshiConverters
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: DaggerApplication): Context =
        application.applicationContext

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(Wrapped.ADAPTER_FACTORY)
            .add(MoshiConverters())
            .build()
    }

}