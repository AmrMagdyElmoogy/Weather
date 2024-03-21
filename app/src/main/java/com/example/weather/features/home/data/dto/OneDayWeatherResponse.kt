package com.example.weather.features.home.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OneDayWeatherResponse(
    val data: Data,
)

@JsonClass(generateAdapter = true)
data class Data(
    val request: List<Request>,
    @Json(name = "current_condition") val condition: List<CurrentCondition>,
    val weather: List<Weather>,
)

@JsonClass(generateAdapter = true)
data class Request(
    val query: String,
)

@JsonClass(generateAdapter = true)
data class CurrentCondition(
    @Json(name = "observation_time") val observationTime: String,
    @Json(name = "temp_C") val temperature: String,
    @Json(name = "weatherDesc") val weatherDesc: List<WeatherDesc>,
    @Json(name = "windspeedMiles") val windMph: String,
    @Json(name = "humidity") val humidity: String,
    @Json(name = "FeelsLikeC") val feelsLike: String,
    @Json(name = "uvIndex") val uvIndex: String,
)

@JsonClass(generateAdapter = true)
data class WeatherDesc(
    val value: String,
)

@JsonClass(generateAdapter = true)
data class Weather(
    val date: String,
    val astronomy: List<Astronomy>,
)

@JsonClass(generateAdapter = true)
data class Astronomy(
    val sunrise: String,
    val sunset: String,
)
