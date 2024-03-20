package com.example.weather.features.home.domin

import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling

interface OneDayWeatherDomain {
    suspend fun fetchOneDayWeather(city: String): ResultHandling<OneDayWeather, NetworkError>
}
