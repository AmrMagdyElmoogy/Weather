package com.example.weather.features.sevenday.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidersDI {
    @Singleton
    @Provides
    fun provideSevenDayWeatherClientApi(retrofit: Retrofit): SevenDayCityWeatherService =
        retrofit.create(SevenDayCityWeatherService::class.java)
}
