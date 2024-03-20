package com.example.weather.features.home.data.api

import com.example.weather.core.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidersDI {
    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(
            BASE_URL,
        ).addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build()

    @Singleton
    @Provides
    fun provideOkHttpClientInstance(): OkHttpClient = OkHttpClient.Builder().addInterceptor(ServiceInterceptor).build()

    @Singleton
    @Provides
    fun provideOneDayWeatherClientApi(retrofit: Retrofit): OneDayCityWeatherService = retrofit.create(OneDayCityWeatherService::class.java)
}
