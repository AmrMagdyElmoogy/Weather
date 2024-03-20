package com.example.weather.features.sevenday.domin

import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling

interface SevenDaysWeatherDomain {
    suspend fun fetchSevenDays(city: String): ResultHandling<List<SevenDaysWeather>, NetworkError>
}
