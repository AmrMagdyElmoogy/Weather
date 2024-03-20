package com.example.weather.features.home.data.api

import com.example.weather.core.DAYS
import com.example.weather.core.FORECAST
import com.example.weather.features.home.data.dto.OneDayWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OneDayCityWeatherService {
    @GET(FORECAST)
    suspend fun fetchOneDayCityWeather(
        @Query("q") city: String,
        @Query(DAYS) oneDay: String = "1",
    ): Response<OneDayWeatherResponse>
}
