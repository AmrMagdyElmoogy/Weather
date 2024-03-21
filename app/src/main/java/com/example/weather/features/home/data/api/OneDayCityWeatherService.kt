package com.example.weather.features.home.data.api

import com.example.weather.core.DAYS
import com.example.weather.core.FORECAST
import com.example.weather.core.HOURS
import com.example.weather.core.QUERY
import com.example.weather.features.home.data.dto.OneDayWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OneDayCityWeatherService {
    @GET(FORECAST)
    suspend fun fetchOneDayCityWeather(
        @Query(QUERY) city: String,
        @Query(DAYS) oneDay: Int = 1,
        @Query(HOURS) hours: String = "1",
    ): Response<OneDayWeatherResponse>
}
