package com.example.weather.features.sevenday.data.api

import com.example.weather.core.DAYS
import com.example.weather.core.FORECAST
import com.example.weather.core.QUERY
import com.example.weather.features.sevenday.data.dto.SevenDaysWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SevenDayCityWeatherService {
    @GET(FORECAST)
    suspend fun fetchSevenDaysCityWeather(
        @Query(QUERY) city: String,
        @Query(DAYS) days: String = "7",
    ): Response<SevenDaysWeatherResponse>
}
