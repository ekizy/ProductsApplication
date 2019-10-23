package com.ekiz.products.injection.module

import android.content.Context
import com.ekiz.products.BuildConfig
import com.ekiz.products.data.NetworkHandler
import com.ekiz.products.data.api.errorhandling.ErrorHandler
import com.ekiz.products.data.api.services.ProductsService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
internal class NetworkModule {

    @Provides
    @Singleton
    internal fun provideNetworkHandler(context: Context): NetworkHandler = NetworkHandler(context)

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, networkHandler: NetworkHandler): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(OkHttpClient.Builder().addInterceptor(ErrorHandler(networkHandler)).build())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideProducstService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

}