package com.example.weather.features.sevenday.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SevenDaysWeatherResponse(
    val data: Data,
)

@JsonClass(generateAdapter = true)
data class Data(
    val request: List<Request>,
    val weather: List<Weather>,
)

@JsonClass(generateAdapter = true)
data class Request(
    val query: String,
)

@JsonClass(generateAdapter = true)
data class Weather(
    val date: String,
    @Json(name = "avgtempC") val temperature: String,
    val hourly: List<Hourly>,
)

@JsonClass(generateAdapter = true)
data class Hourly(
    val time: String,
    val tempC: String,
    val weatherDesc: List<WeatherDesc>,
)

@JsonClass(generateAdapter = true)
data class WeatherDesc(
    val value: String,
)
