package com.example.weather.features.home.domin

import com.example.weather.core.DatabaseError
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.home.domin.entities.OneDayWeather
import kotlinx.coroutines.flow.Flow

interface OneDayWeatherDomain {
    suspend fun fetchOneDayWeather(city: String): ResultHandling<OneDayWeather, NetworkError>

    suspend fun insertNewWeatherData(weather: OneDayWeather)

    suspend fun selectCachedWeatherCity(): ResultHandling<Flow<OneDayWeather?>, DatabaseError>
}
